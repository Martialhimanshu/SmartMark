package com.Teacher_MSIT.teacherassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Kashyap on 3/21/2017.
 */

public class LogoutActivity extends AppCompatActivity {

private FirebaseAuth firebas = FirebaseAuth.getInstance(); ;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
       firebas.signOut();


        FirebaseAuth.AuthStateListener authStateListener =new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                if (firebaseUser == null){
                    startActivity(new Intent(LogoutActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
    }


}
