package io.khasang.bend.controller;

/*
* TODO 09.03.2019
* view all students(include unpublished)
* view all schools(include unpublished)
* view all users
* view all students
* view all vacant students
*/

import io.khasang.bend.entity.School;
import io.khasang.bend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/adminreport")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    @ResponseBody
    public List<School> getAllSchools() {
        return adminService.getAllSchools();
    }
}