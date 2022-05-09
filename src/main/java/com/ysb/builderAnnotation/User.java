package com.ysb.builderAnnotation;

/**
 * @author Huang Bangbang
 * @date 2022/5/9 - 14:46
 */
public class User {
    private Integer id;
    private String name;

    public static Builder builder(){
        Builder<User> builder = new Builder<>();
        builder.setT(new User());
        return builder;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
