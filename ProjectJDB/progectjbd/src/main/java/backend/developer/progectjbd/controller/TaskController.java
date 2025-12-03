package backend.developer.progectjbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import backend.developer.progectjbd.domain.model.Task;
import backend.developer.progectjbd.service.TaskService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/task-api")
public class TaskController {
    
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @PreAuthorize(value = "")
    public List<Task> listTasks() {
        return taskService.listAll();
    }

    @GetMapping("/task/{id}")
    public Task findTaskById(@PathVariable(name = "id") Long id) {
        return taskService.findById(id).orElseThrow();
    }

    @GetMapping("/user/{id}")
    public List<Task> listTasksByUserId(@PathVariable(name = "id") Long id) {
        return taskService.listAllByUserId();
    }

    @GetMapping("/group/{id}")
    public List<Task> listTasksByGroupId(@PathVariable(name = "id") Long id) {
        return taskService.listAllByGroupId();
    }

    @PostMapping(value = "/task")
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }
}
