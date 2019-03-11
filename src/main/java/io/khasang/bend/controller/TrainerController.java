package io.khasang.bend.controller;

import io.khasang.bend.entity.Trainer;
import io.khasang.bend.service.TrainerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    //@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Trainer addBarsuk(@RequestBody Trainer trainer) {
        return trainerService.add(trainer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Trainer updateBarsuk(@RequestBody Trainer trainer) {
        return trainerService.update(trainer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Trainer deleteBarsuk(@PathVariable("id") long id) {
        return trainerService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Trainer getBarsukById(@PathVariable("id") long id) {
        return trainerService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Trainer> getAllBarsuk() {
        return trainerService.getAllTrainers();
    }
}
