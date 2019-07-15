package com.itea.maksymThreads.models;

public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

    public User(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return String.format("User #%s, first name: %s, last name: %s, email: %s, avatar: %s%n", id, firstName, lastName, email, avatar);
    }
}
