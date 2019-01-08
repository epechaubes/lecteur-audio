package com.lecteuraudio.webservice.repository;

import com.lecteuraudio.webservice.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository <Album, Integer> {
}
