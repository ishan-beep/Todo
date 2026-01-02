
package com.ishan.todo.controller;

import com.ishan.todo.entity.TodoEntity;
import com.ishan.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


    @Controller
    @RequestMapping("/todo")
    public class TodoController {

        private final TodoService todoService;

        public TodoController(TodoService todoService) {
            this.todoService = todoService;
        }

        // LIST PAGE
        @GetMapping
        public String listTodos(Model model) {
            //todos is the plural form of todothat defines many data  exist in db which is set in model.addAttribute method
            // this part is used to retrive data from table of db
            model.addAttribute("todos", todoService.getAllTodos());
            return "todo";
        }

        // ADD FORM
        @GetMapping("/new")
        public String showAddForm(Model model) {
            //creating new TOdoform data added in db
            model.addAttribute("todo", new TodoEntity());
            return "todo_form";
        }

        // SAVE / UPDATE
        @PostMapping("/save")
        public String saveTodo(@ModelAttribute TodoEntity todo) {
            //update our db and list
            todoService.saveTodo(todo);
            return "redirect:/todo";
        }

        // EDIT FORM
        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable Long id, Model model) {
            //todoused here is the
            model.addAttribute("todo", todoService.getTodoById(id));
            return "todo_form";
        }

        // DELETE
        @GetMapping("/delete/{id}")
        public String deleteTodo(@PathVariable Long id) {
            todoService.deleteTodo(id);
            return "redirect:/todo";

        }
    }



