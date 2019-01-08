package com.lecteuraudio.webservice.service;

import com.lecteuraudio.webservice.model.Album;
import com.lecteuraudio.webservice.model.Artist;
import com.lecteuraudio.webservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album){
        return albumRepository.save(album);
    }

    public void deleteAlbum(Integer albumId){
        albumRepository.delete(albumId);
    }
}
