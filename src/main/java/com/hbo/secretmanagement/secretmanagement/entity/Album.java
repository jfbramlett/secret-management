package com.hbo.secretmanagement.secretmanagement.entity;

import org.springframework.data.annotation.Id;

public class Album {
    @Id
    private String title;
    private String artist;
    private int year;

    public Album() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
