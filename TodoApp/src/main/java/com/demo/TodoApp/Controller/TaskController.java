package com.demo.TodoApp.Controller;

import com.demo.TodoApp.Model.Task;
import com.demo.TodoApp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public String getAllTasks(Model model) {
        List<Task> allTasks = taskService.findAllTasks();
        model.addAttribute("allTasks", allTasks);
        return "all-tasks";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task, Model model) {
        taskService.addTask();
        model.addAttribute("addTask", task);
        return "add-task";
    }
    
}
