package com.Teacher_MSIT.teacherassistant.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Teacher_MSIT.teacherassistant.AppBase;
import com.Teacher_MSIT.teacherassistant.R;
import com.Teacher_MSIT.teacherassistant.StudentListAdapter;
import com.Teacher_MSIT.teacherassistant.databaseHandler;
import com.Teacher_MSIT.teacherassistant.listAdapter;
import com.Teacher_MSIT.teacherassistant.noteActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Student_list extends AppCompatActivity {

    databaseHandler handler = AppBase.handler;

    ListView students_list;
    StudentListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<String> names;
    ArrayList<String> registers;
    Activity thisActivity = this;
    ArrayList<Boolean> atts;
    Spinner spinner;
    private TextView no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        registers=new ArrayList<>();
        names=new ArrayList<>();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        atts = new ArrayList<>();

        students_list = (ListView) findViewById(R.id.student_listView);

        no_data = (TextView) findViewById(R.id.no_data);
        Button load_list = (Button) findViewById(R.id.load_stu_list);
        assert load_list != null;
        load_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadStudentListView(v);
            }
        });

        Button button_print = (Button) findViewById(R.id.button_print);

        assert button_print != null;
        button_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Printing...", Toast.LENGTH_LONG).show();


                // adapter.saveAll();
            }
        });

        spinner = (Spinner) findViewById(R.id.student_list_Spinner);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, AppBase.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);


    }

    private void loadStudentListView(View v) {
       if(names.size()>0) names.clear();
        if(registers.size()>0) registers.clear();

        String qu = "SELECT * FROM STUDENT WHERE cl = '" + spinner.getSelectedItem().toString() + "' " +
                "ORDER BY ROLL";
        String qc = "SELECT * FROM ATTENDANCE WHERE class = '" + spinner.getSelectedItem()+ "' " +
                "ORDER BY ROLL";
        String qd = "SELECT * FROM ATTENDANCE WHERE register = '" + spinner.getSelectedItem() + "' AND isPresent = 1";


        Cursor cursor = handler.execQuery(qu);
        //Start Count Here


//        if(cursor==null||cursor.getCount()==0)
//        {
//            assert no_data != null;
//            no_data.setText("No Data Available");
//        }else{
////        {
////            String attendance = "";
////            if(att<0)
////            {
////                attendance = "Attendance Not Available";
////            }else
////                attendance = " Attendance " + att + " %";
            int ctr = 0;
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                float att = 0f;
                Cursor cur = handler.execQuery(qc);
                Cursor cur1 = handler.execQuery(qd);
                if(cur==null)
                {
                    Log.d("profile","cur null");
                }
                if(cur1==null)
                {
                    Log.d("profile","cur1 null");
                }
                if(cur!=null)
                {

                    cur.moveToFirst();
                    cur1.moveToFirst();
                    while(!cur.isAfterLast())
                    try{
                        att = ((float) cur1.getCount()/cur.getCount())*100;
                        if(att<=0)
                            att = 0f;
                        Log.d("profile_activity","Total = " + cur.getCount() + " avail = "+cur1.getCount() + " per " + att);
                    }catch (Exception e){att = -1;}

                }
                if(cursor==null||cursor.getCount()==0)
                {
                    assert no_data != null;
                    no_data.setText("No Data Available");
                }else
                {
                    String attendance = "";
                    if(att<0)
                    {
                        attendance = "Attendance Not Available";
                    }else
                        attendance = " Attendance " + att + " %";

                 cursor.moveToFirst();

                names.add(cursor.getString(0) + " (" + cursor.getInt(4) + ')'+ "  "+attendance);
                registers.add(cursor.getString(2));
                cursor.moveToNext();
                ctr++;
            }
            if(ctr==0)
            {
                Toast.makeText(getBaseContext(),"No Students Found",Toast.LENGTH_LONG).show();
            }
            Log.d("Attendance", "Got " + ctr + " students");
        }




        adapter = new StudentListAdapter(thisActivity,names,registers);
        students_list.setAdapter(adapter);
    }



    }