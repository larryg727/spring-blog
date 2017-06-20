package com.codeup.controllers;

import com.codeup.Model.Post;
import com.codeup.Svc.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PostSvc postDao;
    @Autowired
    public PostsController(PostSvc postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showAll(Model model) {
        List<Post> postList = postDao.findAll();
        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public  String showPost(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
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
