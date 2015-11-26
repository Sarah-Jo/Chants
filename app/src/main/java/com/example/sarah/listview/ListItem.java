package com.example.sarah.listview;

import java.io.Serializable;

/**
 * Created by sarah on 10/22/theme.
 */
public class ListItem implements Serializable {
    private String name;
    private int imageId;
    private int number;
    private String lyrics;

    public ListItem(String name, int number, int imageId, String lyrics) {
        this.name = name;
        this.imageId = imageId;
        this.number= number;
        this.lyrics=lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "name='" + name + '\'' +
                ", imageId=" + imageId +
                ", number=" + number +
                ", lyrics='" + lyrics + '\'' +
                '}';
    }
}
