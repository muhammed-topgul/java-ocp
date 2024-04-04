package com.mtopgul.io.serializingData;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author muhammed-topgul
 * @since 04/04/2024 17:08
 */
public class Gorilla implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private Boolean friendly;
    private transient String favoriteFood;

    public Gorilla(String name, int age, Boolean friendly) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getFriendly() {
        return friendly;
    }

    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "Gorilla{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendly=" + friendly +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }
}
