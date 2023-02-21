package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "world");
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return String.format("%d plus 1 is %d", number, number + 1);
    }

    @GetMapping("/exponent/{num}/{pow}")
    public String exponent(@PathVariable int num, @PathVariable int pow, Model model) {
        model.addAttribute("num", num);
        model.addAttribute("pow", pow);
        model.addAttribute("result", (int) Math.pow(num, pow));
        return "exponent";
    }
}
