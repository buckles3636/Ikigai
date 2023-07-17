package com.example.application.data;

public class Listing {
    private User publisher;
    private String date;
    private int views;
    private String titleString;
    private String subtitleString; 
    private String textString;
    private String imageURL;
    private String tag;
    
    public Listing(User publisher, String date, int views, String titleString, 
                   String subtitleString, String textString, String imageURL, String tag) {
        this.publisher = publisher;
        this.date = date;
        this.views = views;
        this.titleString = titleString;
        this.subtitleString = subtitleString;
        this.textString = textString;
        this.imageURL = imageURL;
        this.tag = tag;
        publisher.addUserListing(this.getInstance());
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
}
