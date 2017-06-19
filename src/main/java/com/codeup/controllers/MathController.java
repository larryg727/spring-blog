package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by larryg on 6/19/17.
 */
@Controller
public class MathController {

    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public String addition(@PathVariable int number1, @PathVariable int number2) {
        return String.format("%s + %s = %s", number1, number2, (number1 + number2));
    }

    @GetMapping("/subtract/{number1}/from/{number2}")
    @ResponseBody
    public String subtraction(@PathVariable int number1, @PathVariable int number2) {
        return String.format("%s - %s = %s", number1, number2, (number1 - number2));
    }

    @GetMapping("/multiply/{number1}/and/{number2}")
    @ResponseBody
    public String multiplication(@PathVariable int number1, @PathVariable int number2) {
        return String.format("%s x %s = %s", number1, number2, (number1 * number2));
    }

    @GetMapping("/divide/{number1}/by/{number2}")
    @ResponseBody
    public String division(@PathVariable int number1, @PathVariable int number2) {
        return String.format("%s / %s = %s", number1, number2 , (number1 / number2));
    }




}
