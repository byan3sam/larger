package com.example.largerthanlobster;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class rshomtor extends AppCompatActivity {
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 ;
    ImageView ho;
    Button add;
    TextView test,tvdateshow,hourr;
    EditText torr,placee;
    rshema c= new rshema();
    ImageView im,btn_datepicker,btn_timepick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rshomtor);
        ho = findViewById(R.id.imageView11);
        placee= findViewById(R.id.editText);
        test=findViewById(R.id.textView3);
        torr= findViewById(R.id.editText4);
        tvdateshow= findViewById(R.id.textView4);
        btn_timepick=findViewById(R.id.imageView15);
        hourr= findViewById(R.id.textView15);
        add= findViewById(R.id.button5);
        btn_datepicker=findViewById(R.id.pickdate);
        im=findViewById(R.id.imageView3);
        im.setVisibility(View.INVISIBLE);
        myRef1= database1.getReference("torem");

        btn_datepicker.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // call PickDate for Date
            PickDate();
        }
    });

        btn_timepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call PickTime for Time
                PickTime();
            }
        });



        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
 if (currentDate.equals(tvdateshow.getText().toString().trim())){
    test.setText("jjj");
 }

        addtor();

}



    Calendar calendar = Calendar.getInstance();
    private void PickDate() {
        final java.util.Calendar calendar = java.util.Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(rshomtor.this, new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                /// here set date value in txtview
                tvdateshow.setText(date);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    private void PickTime(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(rshomtor.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay + ":" + minute;
                hourr.setText(time);
                /// here set time value in txtview


            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);

        timePickerDialog.show();
    }



    public void addtor(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(torr.getText().toString().trim())){
                    torr.setError("נא להוסיף תור");
                }
                if (TextUtils.isEmpty(tvdateshow.getText().toString().trim())){
                    tvdateshow.setError("נא להוסיף תאריך");
                }
                if (TextUtils.isEmpty(placee.getText().toString().trim())){
                    placee.setError("נא להוסיף מקום");
                }
                if (TextUtils.isEmpty(hourr.getText().toString().trim())){
                    hourr.setError("נא להוסיף שעה");
                }
                if (!(torr.getText().toString().isEmpty())&& !(hourr.getText().toString().isEmpty())&&
                        !(placee.getText().toString().isEmpty())&&!(tvdateshow.getText().toString().isEmpty())){
                    c.setPlace(placee.getText().toString());
                    c.setDate(tvdateshow.getText().toString());
                    c.setHour(hourr.getText().toString());
                    c.setTor(torr.getText().toString());

                    myRef1.child(c.getTor()).setValue(c).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(rshomtor.this,"התור נוסף ללוח הזמנים ",Toast.LENGTH_LONG).show();
                            im.setVisibility(View.VISIBLE);

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

                }}
        });

    }
}

