package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(value = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @RequestMapping(value = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%d - %d = %d", num1, num2, num2 - num1);
    }

    @RequestMapping(value = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%d * %d = %d", num1, num2, num1 * num2);
    }

    @RequestMapping(value = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%d / %d = %d", num1, num2, num1 / num2);
    }
}
