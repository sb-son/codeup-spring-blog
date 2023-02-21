package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ColorController {
    @GetMapping("/fav-color")
    public String favColorForm() {
        return "fav-color";
    }

    @PostMapping("/fav-color")
    @ResponseBody
    public String whatWasTheFavoriteColor(@RequestParam(name = "color") String color) {
        return String.format("Favorite color is: %s", color);
    }
}
