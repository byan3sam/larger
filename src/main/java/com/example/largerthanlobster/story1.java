package com.example.largerthanlobster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class story1 extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
       t=findViewById(R.id.mr);
       t.setText("מרידה\n" +
               "\n" +
               "כל החיים שלי אהבתי להשתולל, לצחוק, וללכת להרפתקאות, ההורים שלי לא יכלו לתפוס אותי אף פעם. גדלתי ואהבתי ללכת לשבילים שבטבע, לקפוץ מעל סלעים, ללכת שעות על הר ענקי, וכולם היו מופתעים מהיכולות שלי, אני כל כך חזקה ! \n" +
               "עד שיום אחד, לא הרגשתי כך, נפצעתי בחזה, והתגלה לי גידול סרטן, ושמו Ewing sarcoma. מהיום הזה אסרו עלי לעשות ספורט, ללכת להרפתקאות, לקפוץ ולשחק, הם אסרו עליי לחיות ! \n" +
               "כך נראה בעיניי לראשונה, עד שהבנתי שסרטן יכול להיות קשה, מעייף את הגוף ומגביל אותו, ונכון שהחולה מפסיד הרבה מכוחותיך, אך תקופת הסרטן היא הרפתקה בחד עצמה ! היא מחזקת, נותנת הזדמנות להכיר אנשים חדשים, וגם עושה אותך יותר יפה ! \n" +
               "יכול להיות שהסרטן קשה אך אתה יכול למצוא את הכיפיות בו.");

        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(story1.this,MainActivity.class));
            }
        });



    }
}
