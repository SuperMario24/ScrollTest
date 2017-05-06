package com.example.saber.scrolltest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by saber on 2017/5/6.
 */

class CustomImageView extends ImageView{

    private int mLastX;
    private int mLastY;

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        Log.d("info","X:"+x+",Y:"+y);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = x-mLastX;
                int moveY = y-mLastY;
                Log.d("info","mLastX:"+mLastX+",mLastY:"+mLastY);
                Log.d("info","moveX:"+moveX+",moveY:"+moveY);
                int translationX = (int) (this.getTranslationX()+moveX);
                int translationY = (int) (this.getTranslationY()+moveY);
                Log.d("info","translationX:"+this.getTranslationX()+",translationY:"+this.getTranslationX());
                this.setTranslationX(translationX);
                this.setTranslationY(translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;

        }


        mLastX = x;
        mLastY = y;
        return true;
    }
}
