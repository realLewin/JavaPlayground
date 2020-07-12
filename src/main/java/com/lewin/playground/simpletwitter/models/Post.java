package com.lewin.playground.simpletwitter.models;

public class Post {
    private final String title;
    private final String content;

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Post{").append("title: ")
                .append(title).append(", Content: ")
                .append(content).append("}").toString();
    }
}
