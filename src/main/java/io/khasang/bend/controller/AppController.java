package io.khasang.bend.controller;

import io.khasang.bend.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ImportResource(value = "classpath:ioc.xml")
public class AppController {
//        private ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
//    private Cat cat = context.getBean("cat", Cat.class);
    // not recommended
    private Cat cat;

    @RequestMapping("/cat")
    public String getHelloPage(Model model) {
        model.addAttribute("name", cat.getName());
        return "hello";
    }

    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
