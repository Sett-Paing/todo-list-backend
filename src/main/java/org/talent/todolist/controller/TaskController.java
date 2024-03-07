package org.talent.todolist.controller;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talent.todolist.domain.HttpResponse;
import org.talent.todolist.dto.NewCategoryRequest;
import org.talent.todolist.dto.NewTaskRequest;
import org.talent.todolist.entity.Category;
import org.talent.todolist.entity.Task;
import org.talent.todolist.service.CategoryService;
import org.talent.todolist.service.TaskService;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/tasks")
    public ResponseEntity<HttpResponse<Task>> saveNewTask(@RequestBody NewTaskRequest request) {  // @RequestBody annotation is used to bind the parameter with the body of the HTTP request
        Task task = taskService.saveNewTask(request);

        return HttpResponse.createResponse(task, HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<HttpResponse<List<Task>>> getAllTask(){
        List<Task> taskList = taskService.findAll();

        return HttpResponse.createResponse(taskList, HttpStatus.OK);
    }
}
