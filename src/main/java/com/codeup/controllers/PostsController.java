package com.codeup.controllers;

import com.codeup.Model.Post;
import com.codeup.Svc.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public String form(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String create(
            @RequestParam(name="title") String title,
            @RequestParam(name="body") String body,
            Model model
    ) {
        Post post = new Post(title, body);
        postDao.save(post);
        model.addAttribute("post", post);
        return "posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEdit(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String edit(
            @RequestParam(name="title") String title,
            @RequestParam(name="body") String body,
            Model model
    ) {
        Post post = new Post(title, body);   //creating new post from edit for current testing purposes
        postDao.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";
    }


}
