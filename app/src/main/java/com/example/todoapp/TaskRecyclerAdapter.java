package com.example.todoapp;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;

import io.realm.Realm;
import io.realm.RealmResults;

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.ViewHolder>{


    Context context;
    RealmResults<Task> taskList;

    public TaskRecyclerAdapter(Context context, RealmResults<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_task_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskRecyclerAdapter.ViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskOutput.setText(task.getTaskText());

        String formatedTime = DateFormat.getDateTimeInstance().format(task.getTimeCreate());
        holder.dateOutput.setText(formatedTime);
        if (task.getDone()) {
            holder.taskOutput.setPaintFlags(holder.taskOutput.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.doneOutput.setChecked(true);
        } else {
            holder.taskOutput.setPaintFlags(holder.taskOutput.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            holder.doneOutput.setChecked(false);
        }

        holder.doneOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                task.setDone(!task.getDone());
                realm.commitTransaction();
                Toast.makeText(context,"Task status change",Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu menu = new PopupMenu(context, view);
                menu.getMenu()
                        .add("Delete");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getTitle().equals("Delete")){
                            //delete task from list
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            task.deleteFromRealm();
                            realm.commitTransaction();
                            Toast.makeText(context,"Task deleted",Toast.LENGTH_LONG).show();
                        }
                        return true;
                    }
                });

                menu.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskOutput;
        TextView dateOutput;
        CheckBox doneOutput;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskOutput = itemView.findViewById(R.id.taskoutput);
            dateOutput = itemView.findViewById(R.id.timeoutput);
            doneOutput = itemView.findViewById(R.id.cb_done_status);

        }
    }
}
