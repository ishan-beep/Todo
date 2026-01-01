package com.ishan.todo.service.impl;

import com.ishan.todo.entity.TodoEntity;
import com.ishan.todo.repository.TodoRepository;
import com.ishan.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private  final TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public TodoEntity getTodoById(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public TodoEntity saveTodo(TodoEntity todoEntity){
        return todoRepository.save(todoEntity);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}

