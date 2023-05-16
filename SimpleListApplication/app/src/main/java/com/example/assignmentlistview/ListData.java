package com.example.assignmentlistview;

public class ListData {
    final int images;
    final String text;

    public ListData(int images, String text) {
        this.images = images;
        this.text = text;
    }

    public int getImages(){
        return images;
    }

    public String getText(){
        return text;
    }
}
