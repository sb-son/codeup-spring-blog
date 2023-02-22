package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String showGuessPage(Model model) {
        model.addAttribute("roll", null);
        model.addAttribute("guess", null);
        model.addAttribute("message", null);
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int randNum = (int) (Math.random() * 6) + 1;
        model.addAttribute("roll", randNum);
        model.addAttribute("guess", guess);
        if (guess == randNum) {
            model.addAttribute("message", "You guessed right!");
        } else {
            model.addAttribute("message", "The number was " + randNum + ". You lose!");
        }
        return "roll-dice";
    }

//    @GetMapping("/roll-dice/{guess}")
//    public String rollDice(@PathVariable int guess, Model model) {
//        int randNum = (int) (Math.random() * 6) + 1;
//        return "roll-dice";
//    }
}
