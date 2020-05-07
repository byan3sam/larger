package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class story2 extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story2);
        t=findViewById(R.id.st2);
        t.setText("רפונזל \n" +
                "אני רפונזל בעלת השיער הזהב , החלתטי לתרום את שערי לילדים חולי סרטן , לא ידעתי למי לתת את הצמה שלי , לכן שמרתי אותה במגירה עד שיבוא היום ואקדיש אותה לעמותה. האנשים הקרובים לי היו עצובים ומופתעים שהסתפרתי , אבל אני היתי משוכנעת שהשיער שלי יחזור והעיקר שאני אגרום לבן אדם זקוק להרגיש שמח.\n" +
                "אחרי חודשיים הופתעתי שאני חולת סרטן . חשבתי על הצמה שרציתי לתרום ואז החלטתי להשתמש בצמה כדי לייצר פאה מהשערות שלי. \n" +
                "למרות שהפאה הייתה מתאימה לי , אך הייתי משוכנעת שהקרחת יותר טובה ונוחה והיא סמל להלחמה . לכן ,לא התביישתי לצאת לכביש בקרחת .\n" +
                "אחרי הטיפולים השיערות שלי התחילו לצמוח מחדש . הקמתי והשתתפי בקמפיינים לאיסוף צמות במטרה לייצר פאות לילדות חולי סרטן.\n" +
                "אני תמיד אומרת , יכול להיות שהשיער מוסיף יופי אבל הוא לעולם לא היה הסיבה ליופי.");
        findViewById(R.id.hooome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(story2.this,MainActivity.class));

            }
        });
    }
}
