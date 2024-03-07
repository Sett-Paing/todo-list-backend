package org.talent.todolist.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talent.todolist.dto.NewTaskRequest;
import org.talent.todolist.entity.Task;
import org.talent.todolist.repo.TaskRepo;
import org.talent.todolist.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Task saveNewTask(NewTaskRequest request) {
        Task task = mapper.map(request, Task.class);
        return taskRepo.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }


}
