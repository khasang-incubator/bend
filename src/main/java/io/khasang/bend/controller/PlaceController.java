package io.khasang.bend.controller;

import io.khasang.bend.entity.Place;
import io.khasang.bend.service.PlaceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public Place addPlace(@RequestBody Place place) {
        return placeService.add(place);
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public Place updatePlace(@RequestBody Place place) {
        return placeService.update(place);
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public Place deletePlace(@PathVariable("id") long id) {
        return placeService.delete(id);
    }

    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public Place getPlaceById(@PathVariable("id") long id) {
        return placeService.getById(id);
    }

    @RequestMapping(
            value = "/name/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public List<Place> getByName(@PathVariable("name") String name) {
        return placeService.getByName(name);
    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ResponseBody
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}