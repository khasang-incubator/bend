package io.khasang.bend.controller;

import io.khasang.bend.dto.UserDto;
import io.khasang.bend.entity.User;
import io.khasang.bend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User deleteUserById(@PathVariable long id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUserById(@PathVariable long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Set<UserDto> getAllEmployeesByName(@PathVariable("name") String name) {
        return userService.getAllUsersByName(name);
    }
}
