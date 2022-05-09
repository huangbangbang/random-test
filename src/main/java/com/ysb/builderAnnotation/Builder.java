package com.ysb.builderAnnotation;

/**
 * @author Huang Bangbang
 * @date 2022/5/9 - 15:54
 */
public class Builder<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Builder id(Integer id){
        User user = (User)this.getT();
        user.setId(id);
        return this;
    }

    public Builder name(String name){
        User user = (User)this.getT();
        user.setName("jack");
        return this;
    }

    public User build(){
        return (User) this.getT();
    }
}
