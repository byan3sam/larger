package com.example.largerthanlobster;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Showstories extends AppCompatActivity {

    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    myadabter2 ma;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ArrayList<add_story> arrayList= new ArrayList<>();
    ListView listView;
    ImageView h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showstories);
        listView=findViewById(R.id.list);
        myRef1= database1.getReference("batient");
        ma= new myadabter2(Showstories.this,arrayList);
        h=findViewById(R.id.imageView17);
        listView.setAdapter(ma);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Showstories.this,MainActivity.class));
            }
        });
        myRef1.child(auth.getCurrentUser().getUid()).child("mystories").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot newSnapshot : dataSnapshot.getChildren()){
                    arrayList.add(newSnapshot.getValue(add_story.class));
                }
                ma.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Showstories.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Showstories.this,storyselected.class);
                i.putExtra("pos",position);
                startActivity(i);
            }
        });


        //arrayAdapter.notifyDataSetChanged();
    }

}
