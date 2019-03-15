package io.khasang.bend.controller;

import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.service.BarsukService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/barsuk")
public class BarsukController {

    private BarsukService barsukService;

    public BarsukController(BarsukService barsukService) {
        this.barsukService = barsukService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Barsuk addBarsuk(@RequestBody Barsuk barsuk) {
        return barsukService.add(barsuk);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Barsuk updateBarsuk(@RequestBody Barsuk barsuk) {
        return barsukService.update(barsuk);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Barsuk deleteBarsuk(@PathVariable("id") long id) {
        return barsukService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Barsuk getBarsukById(@PathVariable("id") long id) {
        return barsukService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Barsuk> getAllBarsuk() {
        return barsukService.getAllBarsuk();
    }
}
