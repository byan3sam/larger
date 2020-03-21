package com.example.largerthanlobster;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class Storypt1 extends View {
    Bitmap B,C,D,E;
    Handler handler;
    Runnable runnable;
    boolean Flag=false;
    public Storypt1(Context context) {
        super(context);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        B= BitmapFactory.decodeResource(getResources(), R.drawable.crab);
        E= BitmapFactory.decodeResource(getResources(),R.drawable.arrow);
    }
    protected  void onDraw(Canvas canvas){

        canvas.drawBitmap(E, 1143, 158, null);
        if(!Flag){
            canvas.drawBitmap(B, 500, 500, null);
        }
        handler.postDelayed(runnable, 100);
    }
    public boolean onTouchEvent(MotionEvent event) {
        float Ytouch = event.getY();// y
        float Xtouch= event.getX();//x
        System.out.println("Y:   "+ Ytouch);
        System.out.println("X:    "+Xtouch);
       if(!(Xtouch>1123&&Xtouch<1339&&Ytouch>138&&Ytouch<298)){
            Flag=false;
        }
        else{
           Flag=true;
        }
        return true;
    }
}
