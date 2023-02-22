package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class AdController {
    @GetMapping("/ads/{id}")
    public String getOneAd(@PathVariable long id, Model model) {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Video games");
        categories.add("Cars");
        Ad ad = new Ad(id, "Test Ad", "Ad description", 1, categories);
        model.addAttribute("ad", ad);
        model.addAttribute("userIsCreator", true);
        return "ads/show";
    }
}
