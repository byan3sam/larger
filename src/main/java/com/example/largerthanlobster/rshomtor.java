package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class rshomtor extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    ImageButton ho;
    Button add;
    EditText torr,datee,placee,hourr;
    rshema c= new rshema();
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rshomtor);
        ho = findViewById(R.id.imageButton5);
        placee= findViewById(R.id.editText);
        torr= findViewById(R.id.editText4);
        datee= findViewById(R.id.editText3);
        hourr= findViewById(R.id.editText2);
        add= findViewById(R.id.button5);
        im=findViewById(R.id.imageView3);
        im.setVisibility(View.INVISIBLE);
        myRef1= database1.getReference("torem");

        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

addtor();
    }

    public void addtor(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im.setVisibility(View.VISIBLE);
                c.setPlace(placee.getText().toString());
                c.setDate(datee.getText().toString());
                c.setHour(hourr.getText().toString());
                c.setTor(torr.getText().toString());
                myRef1.child(c.getTor()).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(rshomtor.this,"התור נוסף ללוח הזמנים ",Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(rshomtor.this,e.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        Toast.makeText(rshomtor.this,"canceled",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });

    }



}
