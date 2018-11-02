package org.academiadecodigo.bootcamp.server.profiles;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {

    @JsonProperty("username")
    private String username;
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty ("birthday")
    private String birthday;
    @JsonProperty("message")
    private String message;

    public Profile(String username, String name, int age, String birthday, String message){
        this.username = username;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
