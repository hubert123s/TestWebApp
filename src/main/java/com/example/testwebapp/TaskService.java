package com.example.testwebapp;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void createNewTask(String question,String answerA,String answerB,String answerC,String answerD,String correct) {
        Task newTask= new Task(question,answerA,answerB, answerC,answerD,correct);
        this.taskRepository.save( newTask);

    }

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }
}
