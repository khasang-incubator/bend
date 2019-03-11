package io.khasang.bend.controller;

import io.khasang.bend.entity.School;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.khasang.bend.service.SchoolService;


@Controller
@RequestMapping("/school")
public class SchoolController {

    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public School addSchool(@RequestBody School school) {
        return schoolService.add(school);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public School updateSchool(@RequestBody School school) {
        return schoolService.update(school);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public School deleteSchool(@PathVariable("id") long id) {
        return schoolService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public School getSchoolById(@PathVariable("id") long id) {
        return schoolService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<School> getAllSchool() {
        return schoolService.getAllSchools();
    }
}