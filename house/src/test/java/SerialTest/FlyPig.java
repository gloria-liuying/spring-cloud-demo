package SerialTest;

import java.io.Serializable;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/19
 */
public class FlyPig implements Serializable {
//    private static final long serialVersionUID = 5733833020863542521L;
    private Integer age = 22;
    private String name = "jjj";
    private String color = "color";

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
