package com.example.largerthanlobster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up extends Activity {
    FirebaseAuth mAuth;
    EditText etemail,etpassword,etname,etphone;
    Button btnsignup;
    String email,password,name,phone;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    long Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        etemail=findViewById(R.id.etmail);
        etpassword=findViewById(R.id.etpass);
        btnsignup=findViewById(R.id.btnsignup);
        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        databaseReference=database.getReference("batient");
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=etemail.getText().toString().trim();
                password=etpassword.getText().toString().trim();
                name=etname.getText().toString().trim();
                phone=etphone.getText().toString().trim();
                func();

            }
        });
    }

    private void func() {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(sign_up.this,"createUserWithEmail:success",Toast.LENGTH_LONG).show() ;
                            startActivity(new Intent(sign_up.this,MainActivity.class));
                            batient batient=new batient(name,phone,email);
                            FirebaseUser user= mAuth.getCurrentUser();
                            databaseReference.child(user.getUid()).setValue(batient);
                            // databaseReference.child(Long.toString(Index)).setValue(Customer);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(sign_up.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();
                            System.out.println(task.getException());

                        }

                        // ...
                    }
                });

    }
}
