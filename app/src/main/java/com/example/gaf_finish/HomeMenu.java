package com.example.gaf_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeMenu extends AppCompatActivity {

    private Button to_user;
    private Button to_appointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemenu);

        to_user = findViewById(R.id.story1);
        to_appointments = findViewById(R.id.appointments);

        to_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUser();
            }

            public void openUser(){
                Intent intent = new Intent(HomeMenu.this, UserMenu.class);
                startActivity(intent);
            }
        });

        to_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppointments();
            }

            public void openAppointments(){
                Intent intent = new Intent(HomeMenu.this, AppointmentsMenu.class);
                startActivity(intent);
                finish();
            }
        });
    }
}