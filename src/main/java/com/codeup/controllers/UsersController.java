package com.codeup.controllers;

import com.codeup.Model.User;
import com.codeup.Repositories.UsersRepostitory;
import com.codeup.Svc.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    UserSvc userSvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Controller
    public class AuthenticationController {
        @GetMapping("/login")
        public String showLoginForm() {
            return "login";
        }

        @GetMapping("/admin")
        public String admin(){
            return "admin";


        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userSvc.save(user);
    return "redirect:/posts";
    }





}
