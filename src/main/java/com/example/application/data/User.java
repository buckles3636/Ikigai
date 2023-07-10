package com.example.application.data;

import java.util.HashSet;
import com.example.application.views.home.HomeViewCard;
import com.vaadin.flow.server.StreamResource;

public class User {
    private String firstName;
    private String lastName;
    private String location;
    private String email;
    private String password;
    private int age;
    private HashSet<Listing> userListings;
    private HashSet<Listing> acceptedListings;
    private StreamResource profilePic;

    private User(String a, String b, String c, String d, String e, int f, StreamResource g){
        this.firstName = a;
        this.lastName = b;
        this.location = c;
        this.email = d;
        this.password = e;
        this.age = f;
        this.profilePic = g;
        this.userListings = null;
        this.profilePic = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HashSet<Listing> getUserListings() {
        return userListings;
    }

    public void addUserListings(HomeViewCard userListings) {
        //todo
    }

    public HashSet<Listing> getAcceptedListings() {
        return acceptedListings;
    }

    public void setAcceptedListings(HomeViewCard acceptedListings) {
        //todo
    }

    public StreamResource getProfilePic() {
        return profilePic;
    }

    public void setProfilePic() {
        //todo filpath contrusctor
    }
}
