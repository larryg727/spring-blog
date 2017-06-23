package com.codeup.controllers;

import com.codeup.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by larryg on 6/23/17.
 */
@Controller
public class UsersController {

    @Controller
    public class AuthenticationController {
        @GetMapping("/login")
        public String showLoginForm() {
            return "login";
        }
    }

    @GetMapping
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user){

    }
}
