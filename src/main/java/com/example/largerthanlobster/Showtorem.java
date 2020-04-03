package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class Showtorem extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    ArrayList<rshema> arrayList= new ArrayList<>();
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtorem);
        listView=findViewById(R.id.list);
        myRef1= database1.getReference("batient");
        final myadabter ma= new myadabter(Showtorem.this,arrayList);
        listView.setAdapter(ma);
        myRef1.child(auth.getCurrentUser().getUid()).child("mytor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot newSnapshot : dataSnapshot.getChildren()){
                 arrayList.add(newSnapshot.getValue(rshema.class));
                }
             ma.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Showtorem.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Showtorem.this,torselected.class);
                //i.putExtra("tor",(rshema)parent.getAdapter().getItem(position));
                i.putExtra("pos",position);
                startActivity(i);
            }
        });


        //arrayAdapter.notifyDataSetChanged();
    }

}
