package com.codeup.controllers;

import com.codeup.Model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larryg on 6/19/17.
 */
@Controller
public class PostsController {

    @GetMapping("/posts")
    public String showAll(Model model) {
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("Fake title", "body of post. blah...."));
        postList.add(new Post("Notreal", "More content here... and here and so on"));
        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public  String showPost(@PathVariable long id, Model model) {
        Post post = new Post("here is the title of a post", "here is the body of a post.");
        model.addAttribute("post", post);
        return "posts/show";
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
