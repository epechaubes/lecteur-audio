package com.lecteuraudio.webservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn( name = "ArtistId" )
    @JsonBackReference
    private Artist artist;

    public Album(Integer albumId, String title, Artist artist) {
        this.id = albumId;
        this.title = title;
        this.artist = artist;
    }

    public Album(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
