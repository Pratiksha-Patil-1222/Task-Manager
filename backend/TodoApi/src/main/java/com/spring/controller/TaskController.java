package com.spring.controller;


import com.spring.entity.Task;
import com.spring.repository.TaskRepository;
import com.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private TaskRepository tr;
//Insert record
    @PostMapping
    public Task createTask(@RequestBody Task task) {
    	System.out.println("%%%%%%");
        return taskService.createTask(task);
    }
//Retrieve data
    @GetMapping("/{userId}")
    public List<Task> getTasks(@PathVariable Long userId) {
    	System.out.println("%%%%%%");
        return taskService.getTasksByUser(userId);
    }
    @GetMapping("/all")
    public List<Task> getAllTasks() {
    	System.out.println("%%%%%%");
        return taskService.getAllTasks();
    }
    //update data
    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }
 //delete data
        @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
        
        @GetMapping("/id/{id}")
    	public Task getTaskById(@PathVariable long id) {
    		return tr.findById(id).get();
    	}
        
}
