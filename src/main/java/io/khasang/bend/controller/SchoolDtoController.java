package io.khasang.bend.controller;

import io.khasang.bend.dto.SchoolDto;
import io.khasang.bend.entity.School;
import io.khasang.bend.service.SchoolDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/school2")
public class SchoolDtoController {

    private SchoolDtoService schoolService;

    public SchoolDtoController(SchoolDtoService schoolService) {
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
    public SchoolDto getSchoolById(@PathVariable("id") long id) {
        return schoolService.getById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Set<SchoolDto> getSchoolById(@PathVariable("name") String name) {
        return schoolService.getByName(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<SchoolDto> getAll() {
        return schoolService.getAll();
    }
}