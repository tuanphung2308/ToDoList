package com.example.tuanp.todolist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.tuanp.todolist.R;
import com.example.tuanp.todolist.models.ToDoTask;

import java.util.ArrayList;

public class ToDoListArrayAdaptor extends ArrayAdapter<ToDoTask> {
    private ArrayList<ToDoTask> dataSet;
    Context mContext;

    // View lookup cache
    private static class TaskViewCache {
        TextView name;
    }

    public ToDoListArrayAdaptor(ArrayList<ToDoTask> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    public void updateList() {
        notifyDataSetChanged();
    }
    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ToDoTask ToDoTask = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        TaskViewCache viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new TaskViewCache();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (TaskViewCache) convertView.getTag();
            result = convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.name.setText(ToDoTask.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
