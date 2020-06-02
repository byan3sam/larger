package com.example.largerthanlobster;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
Button game,story,sc,wriding,cont;
Dialog d1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
game= findViewById(R.id.button);
story = findViewById(R.id.button2);
sc= findViewById(R.id.button3);
wriding= findViewById(R.id.button4);
cont=findViewById(R.id.cont);
        d1=new Dialog(this);
findViewById(R.id.cont2).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        d1.setContentView(R.layout.logout_di);
        Button yes,No;
        yes=(Button) d1.findViewById(R.id.button19);
        No=(Button) d1.findViewById(R.id.button15);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,choose.class);
                i.putExtra("num",1);
                startActivity(i);
            }
        });
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1.dismiss();
            }
        });
        d1.show();
    }
});
cont.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(getApplicationContext(),contact.class);
        startActivity(i);
    }
});
game.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(getApplicationContext(),games.class);
        startActivity(i);
    }
});

story.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(getApplicationContext(),stories.class);
        startActivity(i);
    }
});

sc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(getApplicationContext(),Schedule.class);
        startActivity(i);
    }
});

wriding.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),writingreading.class);
        startActivity(i);
    }
});
    }
    public void onBackPressed(){

    }
}
