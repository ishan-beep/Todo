package com.ishan.todo.service;

import com.ishan.todo.entity.TodoEntity;

import java.util.List;

public interface TodoService  {

    List<TodoEntity> getAllTodos();
    TodoEntity getTodoById(Long id);
    TodoEntity saveTodo(TodoEntity todoEntity);
    void deleteTodo(Long id);
}
