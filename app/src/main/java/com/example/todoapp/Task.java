package com.example.todoapp;

import io.realm.RealmObject;

public class Task extends RealmObject {
    private Boolean isDone;
    private String taskText;
    private long timeCreate;

//    public Task(String task, long timeCreate) {
//        this.isDone = false;
//        this.taskText = task;
//        this.timeCreate = timeCreate;
//    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String task) {
        this.taskText = task;
    }

    public long getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(long timeCreate) {
        this.timeCreate = timeCreate;
    }
}
