package com.example.application.data;

public class Listing {
    private String key;
    private User publisher;
    private String date;
    private int views;
    private String titleString;
    private String subtitleString; 
    private String textString;
    private String[] materialsList;
    private float materialsCost;
    private String imageURL;
    private String tag;
    private Boolean pending;
    private Boolean approved;
    
    public Listing(User publisher, String key, String date, int views, String titleString, 
                    String textString, String tag, Boolean pending, Boolean approved, String[] materialsList, float materialsCost, String imageURL) {
        this.key = key;
        this.publisher = publisher;
        this.date = date;
        this.views = views;
        this.titleString = titleString;
        this.textString = textString;
        this.tag = tag;
        this.pending = pending;
        this.approved = approved;
        this.materialsList = materialsList;
        this.materialsCost = materialsCost;
        this.imageURL = imageURL;
        
        publisher.addUserListing(this.getInstance());
    }

    public void push() {
        this.pending = false;
    }

    public void pull() {
        this.pending = true;
    }

    public String getKey() {
        return key;
    }

    public Listing getInstance() {
        return this;
    }
    
    public User getPublisher() {
        return publisher;
    }
    
    public String getDate() {
        return date;
    }
    
    public int getViews() {
        return views;
    }
    
    public String getTitleString() {
        return titleString;
    }
    
    public String getSubtitleString() {
        return subtitleString;
    }
    
    public String getTextString() {
        return textString;
    }
    
    public String getImageURL() {
        return imageURL;
    }
    
    public String getTag() {
        return tag;
    }

    public Boolean getPending() {
        return pending;
    }

    public void Approve() {
        approved = true;
    }

    public void Deny() {
        approved = false;
    }

    public String[] getMaterialsList(){
        return materialsList;
    }

    public float getMaterialsCost(){
        return materialsCost;
    }
}
