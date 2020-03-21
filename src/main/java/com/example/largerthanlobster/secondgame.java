package com.example.largerthanlobster;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
public class secondgame extends AppCompatActivity {
    EditText num;
    int rand;
    static int count=0;
    final int min = 1;
    final int max = 100;
    Button b;
    ImageButton tryagain;
    TextView mes,finum,showcount,tragain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondgame);
        mes=findViewById(R.id.textView11);
        num=findViewById(R.id.editText6);
        tryagain=findViewById(R.id.imageButton6);
        tragain=findViewById(R.id.textView13);
        tragain.setText("try again");
        tragain.setVisibility(View.INVISIBLE);
        tryagain.setVisibility(View.INVISIBLE);
        rand = new Random().nextInt((max - min) + 1) + min;
        b= findViewById(R.id.button16);
        finum=findViewById(R.id.textView12);
        showcount=findViewById(R.id.textView14);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=Integer.toString(rand);
                String mystring= num.getText().toString();
                int i = Integer.parseInt(mystring);
               count++;
               showcount.setText("you tried "+count+" times");
                if (count<5)  {
                    if (i==rand) {
                        mes.setText("you win");
                        count=7;
                    }
                    if (i<rand)
                        mes.setText("the number you entered is smaller than the number");
                    if (i>rand)
                        mes.setText("the number you entered is bigger than the number");

                }
                if (count ==5){
                    if (i==rand) {
                        mes.setText("you win");}
                    else {
                    mes.setText("you lose , try again ");
                    }
                finum.setText("the number is "+s);
                    tryagain.setVisibility(View.VISIBLE);
                    tragain.setVisibility(View.VISIBLE);
                tryagain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      count=0;
                      finum.setText(" ");
                      showcount.setText(" ");
                      mes.setText(" ");
                    }

                });

                }

            }
        });

    }
}
