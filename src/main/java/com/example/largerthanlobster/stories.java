package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class stories extends AppCompatActivity {
ImageButton ho;
Storypt1 storypt1;
Button Story1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        ho = findViewById(R.id.imageButton2);
        Story1 = findViewById(R.id.button11);
        Story1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent();
            }
        });
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
    public void Intent(){
        storypt1=new Storypt1(this);
        setContentView(storypt1);
    }
}
