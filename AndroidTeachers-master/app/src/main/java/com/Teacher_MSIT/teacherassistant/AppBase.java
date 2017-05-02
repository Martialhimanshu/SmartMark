package com.Teacher_MSIT.teacherassistant;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.Teacher_MSIT.teacherassistant.activity.MainActivity;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class   AppBase extends Fragment {

    ArrayList<String> basicFields;
    ArrayList<String> teacher_name;
    gridAdapter adapter;
    public static ArrayList<String> divisions;
    GridView gridView;
    public static databaseHandler handler;
    public static Activity activity;
    public TextView current_name;
    //firebase auth object
//    private FirebaseAuth firebaseAuth;


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mai_menu, menu);
//        return true;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.base_layout
                , container, false);
        basicFields = new ArrayList<>();
        teacher_name = new ArrayList<>();
        handler = new databaseHandler(getActivity());
        activity = getActivity();
        current_name = (TextView) v.findViewById(R.id.Current_User);
        //((ActionBarActivity)getActivity()).getSupportActionBar().show();

//
//        //getting firebase auth object
//        firebaseAuth = FirebaseAuth.getInstance();
//

        //if the objects getcurrentuser method is not null
        //means user is already logged in

        divisions = new ArrayList();
        //current_name.setText(firebaseAuth.getCurrentUser().getDisplayName().toString());
        divisions.add("IT-Mobile Computing");
        divisions.add("IT Ad-Hoc");
        divisions.add("IT HVPE");
        divisions.add("Latest Trends IT");
        divisions.add("Soft Computing");

        gridView = (GridView) v.findViewById(R.id.grid);
        basicFields.add("ATTENDANCE");
        basicFields.add("SCHEDULER");
        basicFields.add("MOODLE MSIT");
        basicFields.add("NOTICE");
        adapter = new gridAdapter(activity, basicFields);
        gridView.setAdapter(adapter);
        return v;
    }

}