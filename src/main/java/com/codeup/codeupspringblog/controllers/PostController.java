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
    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(1, "First post", "My first post");
        Post post2 = new Post(2, "Second post", "Another post");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        Post post = new Post(id, "New Post", ("A new post with an id of " + id));
        model.addAttribute("post", post);
        return "posts/show";
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
