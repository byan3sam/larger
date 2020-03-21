package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class readstory extends AppCompatActivity {
Button sh;
EditText e;
TextView t,t1,t2;
ImageView ho;
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readstory);
        sh=findViewById(R.id.button15);
        e=findViewById(R.id.editText10);
        t=findViewById(R.id.textView6);
        t1=findViewById(R.id.textView7);
        t2=findViewById(R.id.textView8);
        ho=findViewById(R.id.imageView5);
        myRef1= database1.getReference("stories");
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e.setVisibility(View.INVISIBLE);
                sh.setVisibility(View.INVISIBLE);
                Query Q =  myRef1.orderByChild("name").equalTo(e.getText().toString());
                Q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                         add_story x = dataSnapshot1.getValue(add_story.class);
                         t.setText(x.getSt());
                         t1.setText(x.getName());
                         t2.setText(x.getWriter());
                     }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
