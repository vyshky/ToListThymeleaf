package com.example.spring.controller;

import com.example.spring.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("task", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        System.out.println("Clear");
        return "redirect:/";
    }
}