package io.khasang.bend.controller;

import io.khasang.bend.service.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private final  Cat cat;

    @Autowired
    public AppController(Cat cat) {
        this.cat = cat;
    }

    @RequestMapping("/cat")
    @Secured({"ROLE_USER", "ROLE_ADMIN"}) // 2ой вариант допуска к странице, + в SecurityConfig добавить @EnableGlobalMethodSecurity(securedEnabled = true)
    public String getCatNamePage(Model model){
        model.addAttribute("name", cat.getName());
        return "cat";
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
        model.addAttribute("password", password); // до хеширование
        model.addAttribute("passwordAfterEncode"
                , new BCryptPasswordEncoder().encode(password)); // после хеширования
        return "password";
    }
}
