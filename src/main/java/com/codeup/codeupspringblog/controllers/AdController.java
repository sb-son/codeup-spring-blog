package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String showAllAds(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String getOneAd(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.findAdById(id));
        model.addAttribute("userIsCreator", true);
        return "ads/show";
    }

    @GetMapping("/ads/{id}/delete")
    public String confirmDelete(@PathVariable long id, Model model) {
        model.addAttribute("ad", adDao.findAdById(id));
        return "ads/delete";
    }

    @PostMapping("/ads/{id}/delete")
    public String deleteAd(@PathVariable long id, @RequestParam(name = "ad-id") long adId) {
        if (id == adId) {
            adDao.delete(adDao.findAdById(id));
        }
        return "redirect:/ads";
    }
}
