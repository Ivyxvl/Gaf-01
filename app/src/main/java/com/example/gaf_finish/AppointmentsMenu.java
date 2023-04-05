package com.example.gaf_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AppointmentsMenu extends AppCompatActivity {
    private ImageView to_home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointmentsmenu);

        to_home = findViewById(R.id.back);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUser();
            }

            public void openUser(){
                Intent intent = new Intent(AppointmentsMenu.this, HomeMenu.class);
                startActivity(intent);
            }
        });


    }
}