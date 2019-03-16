package io.khasang.bend.controller;

import io.khasang.bend.entity.Point;
import io.khasang.bend.service.PointService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/point")
public class PointController {
    private PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Point addPoint(@RequestBody Point point) {
        return pointService.add(point);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Point updatePoint(@RequestBody Point point) {
        return pointService.update(point);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Point deletePoint(@PathVariable("id") long id) {
        return pointService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Point getById(@PathVariable("id") long id) {
        return pointService.getById(id);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Point> getAll() {
        return pointService.getAllPoints();
    }
}
