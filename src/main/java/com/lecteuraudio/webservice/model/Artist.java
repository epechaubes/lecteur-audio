package com.lecteuraudio.webservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ArtistId")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @OneToMany (mappedBy = "artist")
    @JsonManagedReference
    private List<Album> albums;

    public Artist(Integer artistId, String name, List<Album> albums) {
        this.id = artistId;
        this.name = name;
        this.albums = albums;
    }

    public Artist(){    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
