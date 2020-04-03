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

public class torselected extends AppCompatActivity {
    batient b;
    rshema r;
TextView tn;
Button de;
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torselected);
        tn=findViewById(R.id.torname);
        de=findViewById(R.id.del);
        myRef1= database1.getReference("batient").child(auth.getCurrentUser().getUid());

        //rshema selected = (rshema) getIntent().getSerializableExtra("tor");
       // tn.setText(selected.getTor() + " " );
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                b=dataSnapshot.getValue(batient.class);
                 if( b.getMytor()!=null){
                 r = b.getMytor().get(getIntent().getIntExtra("pos",0));
                 tn.setText(" :תור "+r.getTor()+" :תאריך "+r.getDate()+" :שעה "+r.getHour()+" :מקום "+r.getPlace());}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            b.getMytor().remove(getIntent().getIntExtra("pos",0));
            myRef1.setValue(b);
                startActivity(new Intent(torselected.this, Showtorem.class));
            }
        });
    }
}
