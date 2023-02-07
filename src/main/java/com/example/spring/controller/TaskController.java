package com.example.spring.controller;

import com.example.spring.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
public class TaskController {
    @GetMapping("/")
    public String index(Model model) {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setName("firstTask");
        model.addAttribute("task", task);
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        return "redirect:/";
    }
}