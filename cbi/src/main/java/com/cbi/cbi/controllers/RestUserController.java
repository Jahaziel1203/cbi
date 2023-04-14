package com.cbi.cbi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbi.cbi.models.entity.User;
import com.cbi.cbi.models.service.IUserService;

@RestController
@RequestMapping("/restuser")
public class RestUserController {

    @Autowired
    IUserService userService;

    @GetMapping("/finduser")
    public User findUser(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        if (id > 0)
            return userService.findById(id);
        return null;
    }

    @GetMapping("/findusers")
    public List<User> findUser() {
        return userService.findAll();
    }
}
