package io.khasang.bend.controller;

import io.khasang.bend.service.Cat;
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
//    private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private Cat cat = context.getBean("cat", Cat.class);
//    not recommended
    private final Cat cat;
    private final KnightService knightService;

    @Autowired
    public AppController(@Qualifier("murzik") Cat cat, KnightService knightService) {
        this.cat = cat;
        this.knightService = knightService;
    }

    @RequestMapping("/cat")
    public String getHelloPage(Model model) {
        model.addAttribute("name", cat.getName());
        return "hello";
    }

    @RequestMapping("/{val}")
    public String getQuest(@PathVariable("val") String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "quest";
    }
}
