package com.ysb.enumeration;

public enum Season {

    SPRING(1,"春天","是春天啦"),
    SUMMER(2,"夏天","是夏天啦"),
    AUTUMN(3,"秋天","是秋天啦"),
    WINTER(4,"冬天","是冬天啦");

    private Integer status;
    private String name;
    private String des;

    Season(Integer status, String name, String des) {
        this.status = status;
        this.name = name;
        this.des = des;
    }

    public Integer getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Season{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
