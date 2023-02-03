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

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("task", new Task());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task, Model model) {
        System.out.println("PostAdd");
        return "redirect:/";
    }
}