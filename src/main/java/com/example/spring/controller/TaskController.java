package com.example.spring.controller;

import com.example.spring.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
public class TaskController {
    List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
//        model.addAttribute("string", new String());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Task task) {
        task.setId(UUID.randomUUID());
        tasks.add(task);
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute Task task) {
        Optional<Task> taskDel = tasks.stream().filter(x -> x.getId().equals(task.getId())).findFirst();
        tasks.remove(taskDel.get());
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        tasks.clear();
        return "redirect:/";
    }
}