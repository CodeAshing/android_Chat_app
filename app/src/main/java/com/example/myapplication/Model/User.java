package com.example.myapplication.Model;

public class User {

    private String id;
    private String username;
    private String imageURL;
    private  String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){
    }
    public User(String id, String username, String image_url) {
        this.id = id;
        this.username = username;
        this.imageURL = image_url;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImage_url(String imageURL) {
        this.imageURL = imageURL;
    }
}
