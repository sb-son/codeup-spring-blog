package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "all posts";
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
