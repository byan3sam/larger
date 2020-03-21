package com.example.largerthanlobster;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Showtorem extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    ArrayList<String> arrayList= new ArrayList<>();
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtorem);
        listView=findViewById(R.id.list);
        myRef1= database1.getReference("torem");
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot newSnapshot : dataSnapshot.getChildren()){
                    rshema x = newSnapshot.getValue(rshema.class);
//                    x=" "+newSnapshot.getValue(rshema.class).getTor().toString() +"/n" + newSnapshot.getValue(rshema.class).getDate().toString()+
//                            "/n"+newSnapshot.getValue(rshema.class).getHour().toString()+"/n"+newSnapshot.getValue(rshema.class).getPlace().toString() ;
                    arrayList.add(x.tostring());
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter(Showtorem.this,android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Showtorem.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        //arrayAdapter.notifyDataSetChanged();
    }

}
