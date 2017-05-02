package com.Teacher_MSIT.teacherassistant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kashyap on 4/21/2017.
 */

public class StudentListAdapter extends BaseAdapter {
    ArrayList<String> nameList;
    ArrayList<String> registers;
    Activity activity;

    ArrayList<Boolean> attendanceList;
    public StudentListAdapter(Activity activity,ArrayList<String> nameList,ArrayList<String> reg) {
        this.nameList = nameList;
        this.activity = activity;
        this.registers = reg;
        attendanceList = new ArrayList<>();
        for(int i=0; i<nameList.size(); i++)
        {
            attendanceList.add(new Boolean(false));
        }
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater vi = LayoutInflater.from(activity);
            view = vi.inflate(R.layout.student_list_ele, null);

        }
        TextView textView = (TextView) view.findViewById(R.id.student_list_name);
        TextView attendance = (TextView) view.findViewById(R.id.attendance_student);
        textView.setText(nameList.get(i));

        attendance.setText(registers.get(i));
return  view;

    }

    }

