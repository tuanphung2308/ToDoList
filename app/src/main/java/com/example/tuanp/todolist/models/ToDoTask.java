package com.example.tuanp.todolist.models;

public class ToDoTask {
    public ToDoTask(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
