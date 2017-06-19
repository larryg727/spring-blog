package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by larryg on 6/19/17.
 */
@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public  String post(@PathVariable int id) {
        return String.format("view an individual post # %s", id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String form() {
        return "view the form for creating a post";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String create() {
        return "create a new posts";
    }


}
