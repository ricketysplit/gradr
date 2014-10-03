package com.gradr.core.models.entities;

/**
 * Created by r.harkins on 10/3/2014.
 */
public class Student {
    private String lastName;
    private String firstName;
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return id;
    }
}
