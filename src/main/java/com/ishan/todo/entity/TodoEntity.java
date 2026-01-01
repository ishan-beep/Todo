package com.ishan.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@Data                // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor   // Generates no-args constructor
@AllArgsConstructor  // Generates all-args constructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean completed;
}
