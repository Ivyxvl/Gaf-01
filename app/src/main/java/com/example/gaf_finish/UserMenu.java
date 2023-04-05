package com.example.gaf_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserMenu extends AppCompatActivity {
    private ImageView to_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermenu);

        to_home = findViewById(R.id.back);
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUser();
            }

            public void openUser(){
                Intent intent = new Intent(UserMenu.this, HomeMenu.class);
                startActivity(intent);
            }
        });
    }
}