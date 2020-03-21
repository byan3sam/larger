package com.example.largerthanlobster;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class story1 extends AppCompatActivity {
int [] ima;
ImageView a;
Bitmap b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.crab);
        ima = new int[1];
        ima[0]=R.drawable.bald;
        a= findViewById(R.id.imageView);




    }
}
