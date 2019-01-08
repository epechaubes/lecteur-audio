package com.lecteuraudio.webservice.controller;

import com.lecteuraudio.webservice.model.Album;
import com.lecteuraudio.webservice.model.Artist;
import com.lecteuraudio.webservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json",
            value = ""
    )
    public Album album(@RequestBody Album a)
    {
        return albumService.saveAlbum(a);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void artistDelete(@PathVariable(value = "id")Integer id) {
        albumService.deleteAlbum(id);
    }
}
