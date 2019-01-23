package com.susoft.security;

import com.google.common.collect.Sets;
import com.susoft.entity.User;
import com.susoft.security.model.JwtUser;
import com.susoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/18
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(userName);
        if(user==null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.",
                    userName));
        }else{
            List<String> rolesList = userService.findUserRoles(user.getId());
            HashSet<String> roles = Sets.newHashSet();
            roles.addAll(rolesList);
            return new JwtUser(user,roles);
        }
    }
}
