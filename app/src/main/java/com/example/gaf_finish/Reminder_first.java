package com.example.gaf_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Reminder_first extends AppCompatActivity {


    private Button toReminderMenuFirst;
    private ImageView to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_first);


        toReminderMenuFirst = findViewById(R.id.toReminder);
        to_home = findViewById(R.id.backToHome1);


        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUser();
            }

            public void openUser(){
                Intent intent = new Intent(Reminder_first.this, HomeMenu.class);
                startActivity(intent);
            }
        });

        toReminderMenuFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReminderMenu();
            }

            public void openReminderMenu() {
                Intent intent = new Intent(Reminder_first.this, ReminderMenu.class);
                startActivity(intent);
            }
        });
    }
}