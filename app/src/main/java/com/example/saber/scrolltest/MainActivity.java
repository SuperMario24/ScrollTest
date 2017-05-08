package com.example.saber.scrolltest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivTime;
    private Button btn;

    //弹性滑动(延时策略)
    private static final int MESSAGE_SCROLL_TO = 1;
    private static final int FRAME_COUNT = 30;
    private static final int DELAYED_TIME = 33;
    private int mCount = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_SCROLL_TO:
                    mCount++;
                    if(mCount <= FRAME_COUNT){
                        //每一段时间移动的百分比
                        float fraction = mCount/(float)FRAME_COUNT;
                        //根据百分比计算出移动的距离
                        int scrollX = (int) (fraction * 100);
                        //移动的是view内容，而不是view本身
                        ivTime.scrollTo(scrollX,0);
                        handler.sendEmptyMessageDelayed(MESSAGE_SCROLL_TO,DELAYED_TIME);
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivTime = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(MESSAGE_SCROLL_TO);
            }
        });
    }
}
