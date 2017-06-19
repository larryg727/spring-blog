package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larryg on 6/19/17.
 */
@Controller
public class MyController {

    @GetMapping("/resume")
    public String resume(){
        return "resume";
    }

    @GetMapping("/portfolio")
    public String portfolio(){
        return "portfolio";
    }


    @GetMapping("/roll-dice")
    public String dice() {
        return "dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String results(@PathVariable int guess, Model model) {
        int numberOfDice = 6;
        List<Integer> randoms = new ArrayList<>();
        int numberCorrect = 0;
       for(int i = 0; i < numberOfDice; i++){
           int random = (int) (Math.random() * 6 + 1);
           randoms.add(random);
           if(random == guess){
               numberCorrect++;
           }
       }
        model.addAttribute("guess", guess);
        model.addAttribute("randoms", randoms);
        model.addAttribute("correct", numberCorrect);

        return "results";
    }
}
