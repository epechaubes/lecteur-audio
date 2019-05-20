package com.lecteuraudio.webservice.service;

import com.lecteuraudio.webservice.exception.Conflict;
import com.lecteuraudio.webservice.model.Artist;
import com.lecteuraudio.webservice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist findArtistById (Integer id) throws Exception {
        if (artistRepository.exists(id)){
            return artistRepository.findOne(id);
        } else {
            throw new EntityNotFoundException("Il n'existe pas d'artiste d'id : " + id);
        }
    }

    public List<Artist> findArtistByName (String name) throws Exception {
        List<Artist> artist = artistRepository.findByNameContaining(name);
        return artist;
    }

    public Page<Artist> findAll(Integer page, Integer size, String sortDirection, String sortProperty){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection),sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    public Artist saveArtist(Artist a) {
        if(artistRepository.findByNameLike(a.getName()).size()==0) {
            return artistRepository.save(a);
        }else{
            throw new Conflict("l'artist : " + a.getName() + " existe deja.");
        }
    }

    public Artist updateArtist(Integer artistId, Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteArtist(Integer artistId){
        artistRepository.delete(artistId);
    }

}
