package com.codeup.controllers;

import com.codeup.Model.Post;
import com.codeup.Model.User;
import com.codeup.Svc.PostSvc;
import com.codeup.Svc.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by larryg on 6/19/17.
 */
@Controller
public class PostsController {
    private PostSvc postSvc;
    private UserSvc userSvc;


    @Autowired
    public PostsController(PostSvc postSvc, UserSvc userSvc) {
        this.userSvc = userSvc;
        this.postSvc = postSvc;
    }


    
    @GetMapping("/posts")
    public String showAll(Model model) {
        Iterable<Post> postList = postSvc.findAll();
        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public  String showPost(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
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
            @Valid Post post,
            Errors validation,
            Model model
    ) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEdit(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String edit(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String delete(@ModelAttribute Post post) {
        postSvc.deletePost(post.getId());
        return "redirect:/posts";
    }


}
