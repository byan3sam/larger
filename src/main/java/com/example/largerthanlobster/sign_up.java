package com.example.largerthanlobster;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
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
    EditText ver;
    String email,password,name,phone;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    Dialog d1;
    String num;
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
        d1=new Dialog(this);
        databaseReference=database.getReference("batient");
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etemail.getText().toString().trim())) {
                    etemail.setError("נא להכניס אימייל");
                }
                if (TextUtils.isEmpty(etpassword.getText().toString().trim())) {
                    etpassword.setError("נא להניס סיסמה");
                }
                if (TextUtils.isEmpty(etname.getText().toString().trim())) {
                    etname.setError("נא להכניס שם");
                }
                if (TextUtils.isEmpty(etphone.getText().toString().trim())) {
                    etphone.setError("נא להכניס מספר טלפון");
                }
                if (!(etphone.getText().toString().isEmpty()) && !(etname.getText().toString().isEmpty()) &&
                        !(etpassword.getText().toString().isEmpty()) && !(etemail.getText().toString().isEmpty())) {
                    if (etpassword.getText().toString().trim().length() <= 7) {
                        etpassword.setError("על הסיסמה להכיל יותר מ 7 תאים");
                        etpassword.setText("");
                    }
                    if (etphone.getText().toString().trim().length() <10) {
                        etphone.setError("על המספר להיות 10 ספרות");
                        etphone.setText("");
                    }
                    if(!isEmailValid(etemail.getText().toString().trim())){
                        etemail.setError("כתובת אימייל לא חוקית");
                        etemail.setText("");
                    }
                    if (etphone.getText().toString().trim().length() == 10 &&
                        etpassword.getText().toString().trim().length() > 7 &&
                            isEmailValid(etemail.getText().toString().trim())  ) {

                    email = etemail.getText().toString().trim();
                    password = etpassword.getText().toString().trim();
                    name = etname.getText().toString().trim();
                    phone = etphone.getText().toString().trim();
                    d1.setContentView(R.layout.dialogver);
                    num = Integer.toString((int) (Math.random() * 100000 + 100000));
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(etphone.getText().toString(), null, "hello " + name + " , Your Code is :" + num, null, null);
                    ver = (EditText) d1.findViewById(R.id.entercode);
                    Button b;
                    b = (Button) d1.findViewById(R.id.entercode2);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (ver.getText().toString().equals(num)) {
                                func();
                                d1.dismiss();
                            } else {
                                Toast.makeText(sign_up.this, "הקוד שהכנסת לא נכון", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    d1.show();
                }
            }
            }
        });
    }
    public boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private void func() {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(sign_up.this,"ההרשמה בוצעה בהצלחה",Toast.LENGTH_LONG).show() ;
                            startActivity(new Intent(sign_up.this,MainActivity.class));
                            batient batient=new batient(name,phone,email);
                            FirebaseUser user= mAuth.getCurrentUser();
                            databaseReference.child(user.getUid()).setValue(batient);
                            // databaseReference.child(Long.toString(Index)).setValue(Customer);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(sign_up.this, "ההרשמה לא בוצעה בהצלחה",
                                    Toast.LENGTH_LONG).show();
                            System.out.println(task.getException());

                        }

                        // ...
                    }
                });

    }
}
