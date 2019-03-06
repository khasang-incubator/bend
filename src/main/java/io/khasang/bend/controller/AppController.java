package io.khasang.bend.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import io.khasang.bend.service.Cat;
import io.khasang.bend.service.CreateTable;
import io.khasang.bend.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    //        private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private Cat cat = context.getBean("cat", Cat.class);
    // not recommended
    private final Cat cat;
    private final KnightService knightService;
    private final CreateTable createTable;

    @Autowired
    public AppController(@Qualifier("murzik") Cat cat, KnightService knightService, CreateTable createTable) {
        this.cat = cat;
        this.knightService = knightService;
        this.createTable = createTable;
    }

    @RequestMapping("/cat")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String getHelloPage(Model model) {
        model.addAttribute("name", cat.getName());
        return "hello";
    }

    @RequestMapping("/create")
    public String getTableCreateStatus(Model model) {
        model.addAttribute("name", createTable.getAllCatsByName(1L));
        return "create";
    }

    @RequestMapping("/quest/{val}")
    public String getQuest(@PathVariable("val") String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "quest";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("info", "Very secured admin info!");
        return "admin";
    }

    @RequestMapping("/user")
    public String getUserPage(Model model) {
        model.addAttribute("info", "Very secured user info!");
        return "user";
    }

    @RequestMapping("/password/{password}")
    public String getAdminInfo(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
