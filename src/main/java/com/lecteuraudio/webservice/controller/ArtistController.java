package com.lecteuraudio.webservice.controller;

import com.lecteuraudio.webservice.model.Artist;
import com.lecteuraudio.webservice.repository.ArtistRepository;
import com.lecteuraudio.webservice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping("/{id}")
    public Artist findArtistById (@PathVariable(value="id") Integer id) throws Exception {
        return artistService.findArtistById(id);
    }

    @RequestMapping(params = "name")
    public List<Artist> artist(@RequestParam(value="name") String name) throws Exception {
        return artistService.findArtistByName(name);
    }

    @RequestMapping("")
    public Page<Artist> listeEmployeByAsc (@RequestParam(value="page")Integer page, @RequestParam(value = "size")Integer size, @RequestParam(value = "sortDirection")String sortDirection, @RequestParam(value = "sortProperty")String sortProperty){
        return artistService.findAll(page, size, sortDirection, sortProperty);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json",
            value = ""
    )
    public Artist artist( @RequestBody Artist a)
    {
        return artistService.saveArtist(a);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public Artist artist(@PathVariable(value = "id")Integer id,@RequestBody Artist a)
    {
        return artistService.updateArtist(id, a);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void artistDelete(@PathVariable(value = "id")Integer id) {
        artistService.deleteArtist(id);
    }
}
