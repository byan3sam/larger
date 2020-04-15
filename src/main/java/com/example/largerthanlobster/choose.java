package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class choose extends AppCompatActivity {
Button btnsignup , btnlogin ,con;
TextView textView;
FirebaseAuth auth;
int b=0;
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        btnlogin=findViewById(R.id.button17);
        textView=findViewById(R.id.textView16);
        btnsignup=findViewById(R.id.button18);
        con=findViewById(R.id.button8);

        auth=FirebaseAuth.getInstance();
        Bundle ex= getIntent().getExtras();
        if(ex!=null)
        b=ex.getInt("num");
        if(b!=1) {
            if(auth.getCurrentUser() != null) {
                myRef1 = database1.getReference("batient").child(auth.getCurrentUser().getUid());
                con.setEnabled(true);
            }
        }
        else{
            myRef1 = database1.getReference("batient");
            con.setEnabled(false);
        }

        if(myRef1 != null) {
            myRef1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    batient b = dataSnapshot.getValue(batient.class);
                    if (b != null)
                        textView.setText(b.getEmail());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose.this,MainActivity.class));
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose.this,sign_up.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose.this,log_in.class));
            }
        });
    }
}
