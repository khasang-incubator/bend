package io.khasang.bend.controller;

import io.khasang.bend.dto.TrainerDto;
import io.khasang.bend.entity.Trainer;
import io.khasang.bend.service.TrainerDtoService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trainers2")
public class TrainerDtoController {
    private TrainerDtoService trainerService;

    public TrainerDtoController(TrainerDtoService trainerService) {
        this.trainerService = trainerService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.add(trainer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Trainer updateTrainer(@RequestBody Trainer trainer) {
        return trainerService.update(trainer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Trainer deleteTrainer(@PathVariable long id) {
        return trainerService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TrainerDto getTrainerById(@PathVariable long id) {
        return trainerService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<TrainerDto> getAllTrainers() {
        return trainerService.getAll();
    }
}
