package com.example.application.data;

import java.util.HashSet;

public class User {
    private String firstName;
    private String lastName;
    private String location;
    private String email;
    private String password;
    private int age;
    private String profilePicUrl;
    private HashSet<Listing> userListings;
    private HashSet<Listing> acceptedListings;

    public User(String firstName, String lastName, String location, String email, String password, int age, String profilePicUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.email = email;
        this.password = password;
        this.age = age;
        this.profilePicUrl = profilePicUrl;
        this.userListings = new HashSet<>();
        this.acceptedListings = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public HashSet<Listing> getUserListings() {
        return userListings;
    }

    public HashSet<Listing> getAcceptedListings() {
        return acceptedListings;
    }

    public void addUserListing(Listing l){
        userListings.add(l);
    }

    public void acceptListing(Listing l){
        acceptedListings.add(l);
    }
}
