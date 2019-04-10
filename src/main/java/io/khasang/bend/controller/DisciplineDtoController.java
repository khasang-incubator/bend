package io.khasang.bend.controller;

import io.khasang.bend.dto.DisciplineDto;
import io.khasang.bend.entity.Discipline;
import io.khasang.bend.service.DisciplineDtoService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/disciplines")
public class DisciplineDtoController {
    private DisciplineDtoService disciplineService;

    public DisciplineDtoController(DisciplineDtoService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Discipline addDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.add(discipline);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Discipline updateDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.update(discipline);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Discipline deleteStudent(@PathVariable long id) {
        return disciplineService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DisciplineDto getStudentById(@PathVariable long id) {
        return disciplineService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<DisciplineDto> getAll() {
        return disciplineService.getAll();
    }
}
