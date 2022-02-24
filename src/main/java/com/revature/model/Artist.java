package com.revature.model;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="Artist")
public class Artist {
    @Column(name="name")
    private String name;
    @Id
    @Column(name="artist_id")
    private int artist_id;

    public Artist(String name, int artist_id) {
        this.name = name;
        this.artist_id = artist_id;
    }

    public Artist() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", artist_id=" + artist_id +
                '}';
    }
}
