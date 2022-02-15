package com.revature.model;

public class Painting {
    private int artist_id;
    private String title;
    private String url;
    private String genre;
    private int year;

    public Painting(int artist_id, String title, String url, String genre, int year) {
        this.artist_id = artist_id;
        this.title = title;
        this.url = url;
        this.genre = genre;
        this.year = year;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "artist_id=" + artist_id +
                ", name='" + title + '\'' +
                ", url='" + url + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}
