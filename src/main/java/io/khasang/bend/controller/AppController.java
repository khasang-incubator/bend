package io.khasang.bend.controller;

import io.khasang.bend.model.Cat;
import io.khasang.bend.service.CatQuery;
import io.khasang.bend.service.CreateTable;
import io.khasang.bend.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    //        private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private Cat cat = context.getBean("cat", Cat.class);
    // not recommended
    private final Cat cat;
    private final KnightService knightService;
    private final CreateTable createTable;
    private final CatQuery catQuery;

    @Autowired
    public AppController(@Qualifier("murzik") Cat cat, KnightService knightService, CreateTable createTable, CatQuery catQuery) {
        this.cat = cat;
        this.knightService = knightService;
        this.createTable = createTable;
        this.catQuery = catQuery;
    }

    @RequestMapping("/cat")
    public String getHelloPage(Model model) {
        model.addAttribute("name", cat.getName());
        return "hello";
    }

    @RequestMapping("/create")
    public String getTableCreateStatus(Model model) {
        //model.addAttribute("name", catQuery.getCatById(2));
        //model.addAttribute("name", catQuery.getAllCats());
        //model.addAttribute("name", catQuery.updateCatWithId("dydka","very bad",1));
        model.addAttribute("name",catQuery.deleteCatWithId(1));
        model.addAttribute("name",catQuery.addNewCat(1,"dyda","soft"));
        return "create";
    }

    @RequestMapping("/quest/{val}")
    public String getQuest(@PathVariable("val") String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "quest";
    }
}
