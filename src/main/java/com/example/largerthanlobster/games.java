package com.example.largerthanlobster;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class games extends AppCompatActivity {
ImageView ho;
Button g1,g2,di1,di2;
Dialog d1,d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ho = findViewById(R.id.imageView10);
        g1=findViewById(R.id.button11);
        g2=findViewById(R.id.button10);
        di1=findViewById(R.id.dia1);
        di2=findViewById(R.id.dia2);
        d1=new Dialog(this);
        d2=new Dialog(this);
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),firstgame.class);
                startActivity(i);
            }
        });

        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),secondgame.class);
                startActivity(i);
            }
        });

        di1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              d1.setContentView(R.layout.dialog1);
                Button end1;
                end1=(Button) d1.findViewById(R.id.end);
                 end1.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         d1.dismiss();
                     }
                 });
                d1.show();
            }

        });

        di2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d2.setContentView(R.layout.dialog2);
                ImageView bom;
                Button end2;
                end2=(Button) d2.findViewById(R.id.end2);
                end2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d2.dismiss();
                    }
                });
                d2.show();
            }

        });

    }
}
