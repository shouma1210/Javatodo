package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity implements AddTaskDialog.AddTaskDialogListener {

    private Button addTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskBtn = findViewById(R.id.add_task_btn);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Task> taskList = realm.where(Task.class).findAll().sort("timeCreate", Sort.DESCENDING);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TaskRecyclerAdapter taskRecyclerAdapter = new TaskRecyclerAdapter(getApplicationContext(), taskList);
        recyclerView.setAdapter(taskRecyclerAdapter);

        taskList.addChangeListener(new RealmChangeListener<RealmResults<Task>>() {
            @Override
            public void onChange(RealmResults<Task> tasks) {
                taskRecyclerAdapter.notifyDataSetChanged();
            }
        });

    }

    private void openDialog() {
        AddTaskDialog addTaskDialog = new AddTaskDialog();
        addTaskDialog.show(getSupportFragmentManager(), "add task dialog");
    }

    @Override
    public void addTask(String taskText, Context context) {
        Realm.init(context);
        Realm realm = Realm.getDefaultInstance();

        long currentTime = System.currentTimeMillis();

        realm.beginTransaction();
        Task task = realm.createObject(Task.class);
        task.setTaskText(taskText);
        task.setDone(false);
        task.setTimeCreate(currentTime);
        realm.commitTransaction();
        Toast.makeText(getApplicationContext(),"Saved new task",Toast.LENGTH_LONG).show();
    }
}