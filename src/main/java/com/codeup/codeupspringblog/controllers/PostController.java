package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private static Validator validator;

    public static void setValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

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

//    @GetMapping("/posts/create")
//    public String createForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String save(@ModelAttribute("post") Post post) {
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String showForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String save(@Valid @RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Errors validation, Model model, Post post) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        } else {
            User user = userDao.findUserById(1);
            post = new Post(title, body, user);
            postDao.save(post);
            return "redirect:/posts";
        }
    }


}
