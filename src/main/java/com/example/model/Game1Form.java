package com.example.model;

public class Game1Form {
    private String name;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }



    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Game1Form{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
