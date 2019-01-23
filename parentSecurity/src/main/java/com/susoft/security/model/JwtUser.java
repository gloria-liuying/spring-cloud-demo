package com.susoft.security.model;

import com.susoft.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/19
 */
public class JwtUser implements UserDetails {

    private static final long serialVersionUID = -5588513646752755073L;

    private Collection<? extends GrantedAuthority> authorities;
    private User user;

    public JwtUser(User user, Collection<? extends GrantedAuthority> authorities){
        super();
        this.user = user;
        this.authorities = authorities;
    }
    public JwtUser(User user,Set<String> roles){
        super();
        this.user=user;
        this.authorities = roles.stream().map(role ->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return user.getState()==1;
    }
}
