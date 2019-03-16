package io.khasang.bend.controller;

/*
 * TODO 09.03.2019
 * view unpublished students
 * view unpublished schools
 */

import io.khasang.bend.entity.*;
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

    @RequestMapping(value = "/all-schools", method = RequestMethod.GET)
    @ResponseBody
    public List<School> getAllSchools() {
        return adminService.getAllSchoolsReport();
    }

    @RequestMapping(value = "/all-disciplines", method = RequestMethod.GET)
    @ResponseBody
    public List<Discipline> getAllDisciplines() {
        return adminService.getAllDisciplinesReport();
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return adminService.getAllUsersReport();
    }

    @RequestMapping(value = "/all-students", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return adminService.getAllStudentsReport();
    }

    @RequestMapping(value = "/all-managers", method = RequestMethod.GET)
    @ResponseBody
    public List<Manager> getAllManagers() {
        return adminService.getAllManagersReport();
    }

    @RequestMapping(value = "/all-photographs", method = RequestMethod.GET)
    @ResponseBody
    public List<Photograph> getAllPhotographs() {
        return adminService.getAllPhotographsReport();
    }

    @RequestMapping(value = "/vacant-photographs", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getVacantStudents() {
        return adminService.getVacantStudentsReport();
    }
}