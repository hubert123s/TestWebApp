package com.example.testwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class TaskController {

 private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping("/save")
    @ResponseBody
    String createNewTask(@RequestParam( required = false) String question,
                         @RequestParam String answerA,
                         @RequestParam String answerB,
                         @RequestParam String answerC,
                         @RequestParam String answerD,
                         @RequestParam String correct)
    {
        taskService.createNewTask(question,answerA,answerB, answerC,answerD,correct);
        return "showTask";
    }
    @RequestMapping("/showTask")
    String allquestions(Model model)
    {
        List<Task> tasks= taskService.findAll();

       model.addAttribute("tasks",tasks);
        return"showTask";
    }

}
