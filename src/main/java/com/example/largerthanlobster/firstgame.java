package com.example.largerthanlobster;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class firstgame extends AppCompatActivity {

    final int min = 1;
    final int max = 100;
    int x =0,winn=0,losee=0;
    int random;
    Button Stop;
    TextView boom,win,lose,Number,again;
    boolean flag=true;
    Handler handler;
    Runnable runnable=null;
    ImageView ho;
    ImageButton trya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstgame);
        Stop = findViewById(R.id.btn_stop);
        Number =(TextView) findViewById(R.id.random);
        win = findViewById(R.id.Win);
        again=findViewById(R.id.textView3);
        lose = findViewById(R.id.Lose);
        trya=findViewById(R.id.imageButton);
        trya.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);
        final Handler handler= new Handler() ;
        boom = findViewById(R.id.Boom);
        Number.setText("Hi");
        ho = findViewById(R.id.imageView4);
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if(x%2!=0&&x<10){
                    flag = false;

                }

                else{
                    if (x < 10) {
                        flag=true;

                       handler.postDelayed(runnable,500);
                    }

                }
                if(x==10){
                    Stop.setEnabled(false);
                    if (winn >= 3){
                        boom.setTextColor(Color.GREEN);
                        boom.setText("יאהווו , ניצחת");
                    }
                    else{
                        boom.setTextColor(Color.RED);
                        boom.setText("אוופס :( , נסה שוב ואולי תנצח");

                    }
                    trya.setVisibility(View.VISIBLE);
                    again.setVisibility(View.VISIBLE);
trya.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        x =0;
        winn=0;
        losee=0;
        startActivity(new Intent(firstgame.this,firstgame.class));
    }
});

                }
            }



        });



        runnable=new Runnable() {
            @Override
            public void run() {
                if(x<10){
                    boom.setText("");

                    random = new Random().nextInt((max - min) + 1) + min;
                    if(!flag&&random%7==0){
                        boom.setText("Boom");
                        winn++;
                    }
                    else if((!flag&&random%7!=0)){

                        losee++;
                    }

                    win.setText(""+winn);
                    lose.setText(""+(losee));
                    Number.setText(" " + random);
                    if(flag)
                        handler.postDelayed(this,200);}
            }
        };
        handler.postDelayed(runnable,100);
    }
}
