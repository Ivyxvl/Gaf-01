package com.example.gaf_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeMenu extends AppCompatActivity {

    private Button toUserMenu;
    private Button toReminderMenuFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemenu);

        toUserMenu = findViewById(R.id.user);
        toReminderMenuFirst = findViewById(R.id.reminder);

        toUserMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUser();
            }

            public void openUser() {
                Intent intent = new Intent(HomeMenu.this, UserMenu.class);
                startActivity(intent);
            }
        });

        toReminderMenuFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReminder();
            }

            public void openReminder() {
                Intent intent = new Intent(HomeMenu.this, Reminder_first.class);
                startActivity(intent);
            }
        });
    }
}