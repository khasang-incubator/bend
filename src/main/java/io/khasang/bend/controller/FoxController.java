package io.khasang.bend.controller;

import io.khasang.bend.entity.Fox;
import io.khasang.bend.service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fox")
public class FoxController {
    private FoxService foxService;

    public FoxController(FoxService foxService) {
        this.foxService = foxService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Fox addFox(@RequestBody Fox fox) {
        return foxService.add(fox);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Fox updateFox(@RequestBody Fox fox) {
        return foxService.update(fox);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Fox deleteFox(@PathVariable("id") long id) {
        return foxService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Fox getFoxById(@PathVariable("id") long id) {
        return foxService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Fox> getAllFoxes() {
        return foxService.getAllFoxes();
    }
}