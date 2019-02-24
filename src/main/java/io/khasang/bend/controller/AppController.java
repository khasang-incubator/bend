package io.khasang.bend.controller;

import io.khasang.bend.model.dao.CatDao;
import io.khasang.bend.service.Cat;
import io.khasang.bend.service.CreateTable;
import io.khasang.bend.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    //        private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private Cat cat = context.getBean("cat", Cat.class);
    // not recommended
    private final Cat cat;
    private final KnightService knightService;
    private final CreateTable createTable;
    private final CatDao catDao;

    @Autowired
    public AppController(@Qualifier("murzik") Cat cat, KnightService knightService, CreateTable createTable, CatDao catDao) {
        this.cat = cat;
        this.knightService = knightService;
        this.createTable = createTable;
        this.catDao = catDao;
    }

    @RequestMapping("/create")
    public String getTableCreateStatus(Model model) {
        model.addAttribute("name", createTable.getTableCreationStatus("cats"));
        //model.addAttribute("name", createTable.getAllCatsByName(1L));
        return "create";
    }

    @RequestMapping("/select")
    public String getSelectFromTable(Model model) {
        model.addAttribute("name", createTable.getAllCatsByName(1l));
        //model.addAttribute("name", createTable.getAllCatsByName(1L));
        return "create";
    }

    @RequestMapping("/quest/{val}")
    public String getQuest(@PathVariable("val") String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "quest";
    }

    //http://localhost:8080/cat/create?id=2&name=vaska&description=voryugahttp://localhost:8080/cat/create?id=2&name=vaska&description=voryuga
    @RequestMapping("/cat/create")
    public String getCatCreateStatus(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("description") String desc, Model model) {
        //model.addAttribute("info", knightService.getAchievement(enemy));
        model.addAttribute("info", catDao.create(id, name, desc));
        return "catCrud";
    }

    //http://localhost:8080/cat/update?id=2&name=vaska&description=voryuga
    @RequestMapping("/cat/update")
    public String getCatUpdateStatus(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("description") String desc, Model model) {
        model.addAttribute("info", catDao.update(name, desc, id));
        return "catCrud";
    }

    //http://localhost:8080/cat/delete?id=3
    @RequestMapping("/cat/delete")
    public String getDeleteStatus(@RequestParam("id") Long id, Model model) {
        model.addAttribute("info", catDao.delete(id));
        return "catCrud";
    }

}