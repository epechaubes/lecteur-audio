package com.lecteuraudio.webservice.repository;

import com.lecteuraudio.webservice.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    List<Artist> findByNameLike (String name);

    Page<Artist> findAll(Pageable pageable);

}
