package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts/index")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("First post", "My first post");
        Post post2 = new Post("Second post", "Another post");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showPost(@PathVariable int id) {
        return "this is a post with id of #" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "This creates a new post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String save() {
        return "Stores the user post to the database";
    }
}
