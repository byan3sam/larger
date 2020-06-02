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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class log_in extends AppCompatActivity {
    EditText userEmail, userPassword;
    Button btnlogin,btnforget;
    FirebaseDatabase database =  FirebaseDatabase.getInstance();
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        btnlogin = findViewById(R.id.login);
        btnforget= findViewById(R.id.forget);
        databaseReference = database.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(userEmail.getText().toString().trim())) {
                    userEmail.setError("נא להכניס אימייל");
                }
                if (TextUtils.isEmpty(userPassword.getText().toString().trim())) {
                    userPassword.setError("נא להניס סיסמה");
                }
                if ( !(userPassword.getText().toString().isEmpty()) && !(userEmail.getText().toString().isEmpty())){
                firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(log_in.this, "הכניסה בוצעה בהצלחה ", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(log_in.this, MainActivity.class));

                        } else {
                            Toast.makeText(log_in.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                });}
            }
        });
         btnforget.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String email=userEmail.getText().toString().trim();
                 if (TextUtils.isEmpty(email)){
                     Toast.makeText(getApplication(),"enter your email",Toast.LENGTH_SHORT).show();
                     return;
                 }

                 firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task) {
                         if (task.isSuccessful()){
                             Toast.makeText(log_in.this, "שלחנו לך הוראות להחזרת הסיסמה ", Toast.LENGTH_LONG).show();
                         }
                         else{
                             Toast.makeText(log_in.this, " נכשלה החזרת הסיסמה ", Toast.LENGTH_LONG).show();

                         }
                     }
                 }) ;
             }

         });
    }
}