package com.codeup.controllers;

import com.codeup.Model.Comment;
import com.codeup.Model.Post;
import com.codeup.Model.User;
import com.codeup.Svc.CommentSvc;
import com.codeup.Svc.PostSvc;
import com.codeup.Svc.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by larryg on 6/19/17.
 */
@Controller
public class PostsController {
    private PostSvc postSvc;
    private UserSvc userSvc;
    private CommentSvc commentSvc;
    @Value("${file-upload-path}")
    private String uploadPath;



    @Autowired
    public PostsController(PostSvc postSvc, UserSvc userSvc, CommentSvc commentSvc) {
        this.userSvc = userSvc;
        this.postSvc = postSvc;
        this.commentSvc = commentSvc;
    }

    @GetMapping("/posts.json")
    public @ResponseBody Iterable<Post> viewAllPostInJson() {
        return postSvc.findAll();
    }

    @GetMapping("/posts/ajax")
    public String viewAllPostByAjax() {
        return "posts/ajax";
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
        model.addAttribute("comment", new Comment());
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/comment")
    public String addComment(
            @Valid Comment comment,
            Errors validation,
            Model model,
            @RequestParam(name = "post_id") Long id
    ) {
        if(validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("comment", comment);
            return "/posts/" + id;
        }
        comment.setPost(postSvc.findOne(id));
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUser(user);
        commentSvc.save(comment);
        return "redirect:/posts/" + id;

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
            @RequestParam(name = "file") MultipartFile uploadedFile,
            Model model
    ) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        post.setImageUrl(filename);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        User author = post.getUser();
        User userloggedin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(author.getId() == userloggedin.getId()) {
            model.addAttribute("post", post);
            return "posts/edit";
        }else{
            return "redirect:/profile";
        }
    }

    @PostMapping("/posts/edit")
    public String edit(@ModelAttribute Post post,  @RequestParam(name = "file") MultipartFile uploadedFile) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        post.setImageUrl(filename);
        User userloggedin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userloggedin);
        postSvc.save(post);
        return "redirect:/profile";
    }

    @PostMapping("/posts/delete")
    public String delete(@ModelAttribute Post post) {
        postSvc.deletePost(post.getId());
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String usersPost(Model model) {
        User userloggedin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Iterable<Post> postByUser = postSvc.findByUser(userloggedin.getId());
        model.addAttribute("user", userloggedin);
        model.addAttribute("posts", postByUser);
        return "posts/user";
    }


}
