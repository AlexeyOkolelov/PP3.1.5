package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;


@Controller()
@RequestMapping("admin")
public class AdminController {

    private final UserService userServise;
    private final RoleService roleServise;

    public AdminController(UserService userServise, RoleService roleServise) {
        this.userServise = userServise;
        this.roleServise = roleServise;
    }


    @GetMapping("")
    public String showAllUser(ModelMap model, Principal principal) {
        model.addAttribute("admin", userServise.findUserByName(principal.getName()));
        model.addAttribute("people", userServise.getAllUser());
        model.addAttribute("person", new User());
        model.addAttribute("roles", roleServise.getAllRole());
        return "admin";
    }





}
