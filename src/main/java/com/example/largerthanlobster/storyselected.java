package com.example.largerthanlobster;

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

public class storyselected extends AppCompatActivity {

    batient b;
    add_story r;
    TextView tn;
    Button de;
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storyselected);
        tn=findViewById(R.id.storyname);
        de=findViewById(R.id.del);
        myRef1= database1.getReference("batient").child(auth.getCurrentUser().getUid());

        //rshema selected = (rshema) getIntent().getSerializableExtra("tor");
        // tn.setText(selected.getTor() + " " );
        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                b=dataSnapshot.getValue(batient.class);
                if( b.getMystories()!=null){
                    r = b.getMystories().get(getIntent().getIntExtra("pos",0));
                    tn.setText("story name :    "+r.getName()+"\n"+"writer:    "+r.getWriter()+"\n"+"story:    " + r.getSt());}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.getMystories().remove(getIntent().getIntExtra("pos",0));
                myRef1.setValue(b);
                finish();
            }
        });
    }
}
