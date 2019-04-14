package io.khasang.bend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/showtemplate")
public class ShowTemplatesController {
    @RequestMapping("/student")
    public String getStudentPage() {
        return "student-template";
    }
    @RequestMapping("/trainer")
    public String getTrainerTemplate() {
        return "trainer-template";
    }
    @RequestMapping("/manager")
    public String getManagerTemplate() {
        return "manager-template";
    }
}