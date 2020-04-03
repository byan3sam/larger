package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class writingreading extends AppCompatActivity {
ImageView h;
Button adst,rdst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writingreading);
        h=findViewById(R.id.imageView12);
        adst=findViewById(R.id.button13);
        rdst=findViewById(R.id.button12);
adst.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i2=new Intent(getApplicationContext(),adddd_story.class);
        startActivity(i2);
    }
});

rdst.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i2=new Intent(getApplicationContext(),Showstories.class);
        startActivity(i2);
    }
});

h.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
});

    }
}
