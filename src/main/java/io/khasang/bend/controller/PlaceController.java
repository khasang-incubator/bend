package io.khasang.bend.controller;

import io.khasang.bend.entity.Place;
import io.khasang.bend.service.PlaceService;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Place addPlace(@RequestBody Place place) {
        return placeService.add(place);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Place updatePlace(@RequestBody Place place) {
        return placeService.update(place);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Place deletePlace(@PathVariable("id") long id) {
        return placeService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Place getPlaceById(@PathVariable("id") long id) {
        return placeService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}