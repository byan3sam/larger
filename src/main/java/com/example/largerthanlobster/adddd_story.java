package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adddd_story extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef2 ;
    ImageView h;
    Button add;
    EditText name,writer,text;
    add_story s= new add_story();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddd_story);
        h=findViewById(R.id.imageView2);
        add =findViewById(R.id.button14);
        myRef2= database1.getReference("stories");
        name=findViewById(R.id.editText7);
        writer=findViewById(R.id.editText9);
        text=findViewById(R.id.editText8);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        addst();

    }
    public void addst(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             s.setName(name.getText().toString());
                s.setWriter((writer.getText().toString()));
                s.setSt(text.getText().toString());
                myRef2.child(s.getName()).setValue(s).addOnSuccessListener(new OnSuccessListener<Void>() {
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
});

    }
}
