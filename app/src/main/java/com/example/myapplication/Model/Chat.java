package com.example.myapplication.Model;

public class Chat {

    private String sender;
    private String receiver;
    private String message;
    private boolean isseeen;

    public Chat(String sender, String receiver, String message,boolean isseeen) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isseeen = isseeen;
    }

    public Chat() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsseeen() {
        return isseeen;
    }

    public void setIsseeen(boolean isseeen) {
        this.isseeen = isseeen;
    }
}
