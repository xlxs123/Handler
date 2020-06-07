package com.jin;

public class Message {
    String obj;
    Handler target;

    public Message(String obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return obj.toString();
    }
}
