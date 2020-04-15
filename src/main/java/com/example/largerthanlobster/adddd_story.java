package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class adddd_story extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef2 ;
    Button add;
    ArrayList<add_story> mystory;
    EditText name,writer,text;
    FirebaseAuth auth;
    add_story s= new add_story();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddd_story);
        add =findViewById(R.id.button14);
        myRef2= database1.getReference("batient");
        name=findViewById(R.id.editText7);
        writer=findViewById(R.id.editText9);
        text=findViewById(R.id.editText8);
        auth=FirebaseAuth.getInstance();
        mystory= new ArrayList<add_story>();

        addst();

    }
    public void addst(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(name.getText().toString().trim())){
                    name.setError("נא להוסיף כותרת לסיפור");
                }
                if (TextUtils.isEmpty(writer.getText().toString().trim())){
                    writer.setError("נא להוסיף שם כותב");
                }
                if (TextUtils.isEmpty(text.getText().toString().trim())){
                    text.setError("נא להוסיף תוכן");
                }

                if (!(name.getText().toString().isEmpty())&& !(writer.getText().toString().isEmpty())&&
                        !(text.getText().toString().isEmpty())){
             s.setName(name.getText().toString());
                s.setWriter((writer.getText().toString()));
                s.setSt(text.getText().toString());
                 mystory.add(s);
                    myRef2.child(auth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            batient st=   dataSnapshot.getValue(batient.class);
                            ArrayList<add_story> tmp = st.getMystories();
                            if(tmp == null)
                                tmp = new ArrayList<>();
                            for(add_story value: mystory){
                                tmp.add(value);
                            }
                            st.setMystories(tmp);

                            myRef2.child(auth.getCurrentUser().getUid()).setValue(st).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(adddd_story.this,"הסיפור הועלה ",Toast.LENGTH_LONG).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(adddd_story.this,e.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    startActivity(new Intent(adddd_story.this,writingreading.class));
    }}
});

    }
}
