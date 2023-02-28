package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("titleError", null);
        model.addAttribute("bodyError", null);
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String savePost(@Valid @ModelAttribute Post post, BindingResult bindingResult, Model model) {
        User user = userDao.findUserById(1);
        post.setUser(user);

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                String errorMessage = error.getDefaultMessage();
                if (error.getField().equals("title")) {
                    model.addAttribute("titleError", errorMessage);
                } else if (error.getField().equals("body")) {
                    model.addAttribute("bodyError", errorMessage);
                }
            }
            return "posts/create";
        }
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/edit")
    public String editPostForm(Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/create";
    }
}
