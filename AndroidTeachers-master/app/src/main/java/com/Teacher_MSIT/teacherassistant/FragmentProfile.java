package com.Teacher_MSIT.teacherassistant;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Kashyap on 4/22/2017.
 */

public class FragmentProfile extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ImageView imageView;
    TextView textView3,textView4,textView6;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        firebaseAuth= FirebaseAuth.getInstance();
        Log.d("fragment profile","dsfsd");
        // Inflate the layout for this fragment
        imageView = (ImageView)findViewById(R.id.imageView);
         textView3 = (TextView)findViewById(R.id.textView3);
         textView4 = (TextView)findViewById(R.id.textView4);
         textView6 = (TextView)findViewById(R.id.textView6);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user==null) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }else if(user.getUid().equals("oSkFngjzGPUpeBafpskNzY4l1ul1")) {
            //Toast.makeText(getContext(),"hi",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.prabhjot1);
            textView3.setText("Dr. Prabhjot Kaur");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));


            textView4.setText("Associate Professor");
            textView4.setTextColor(Color.BLACK);

            textView6.setText("B.Tech,M.Tech,Ph.D");
            textView6.setTextColor(Color.BLACK);

        }
        else if(user.getUid().equals("YD8L4UKZEhdb6MWzTORQmTHh0H03")) {
            imageView.setImageResource(R.drawable.surender);
            textView3.setText("Dr. Surender Bhanwala");
            textView3.setTextColor(Color.RED);

            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));
            textView4.setText("Assistant Professor");
            textView4.setTextColor(Color.BLACK);
            textView6.setText("B.Tech,M.Tech");
            textView6.setTextColor(Color.BLACK);

        }

        if(user.getUid().equals("ZeglAGrkbLdE72OBObuunM1EI2T2")) {

            imageView.setImageResource(R.drawable.sonika);
            textView3.setText("Sonika Malik");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));



            textView4.setText("Assistant Professor");
            textView4.setTextColor(Color.BLACK);

            textView6.setText("B.Tech(CSE),M.Tech(IT)");
            textView6.setTextColor(Color.BLACK);

        }
        else if(user.getUid().equals("Hw5DqN2UeDaUBtPRLrwRHm35X5N2")) {
            imageView.setImageResource(R.drawable.anupma);
            textView3.setText("Dr. Anupama Kaushik ");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));



            textView4.setText("Assistant Professor");
            textView4.setTextColor(Color.BLACK);

            textView6.setText("B.Tech,M.Tech,Ph.D");
            textView6.setTextColor(Color.BLACK);

        }


    }
}
