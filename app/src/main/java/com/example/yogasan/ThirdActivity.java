package com.example.yogasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Button button;
    TextView mtextview;
    private CountDownTimer countDownTimer;
    private  boolean mTimerRunning;
    private  long mtimeleft;
    String buttonvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
         buttonvalue=intent.getStringExtra("Value");
         int intvalue=Integer.valueOf(buttonvalue);


        switch (intvalue)
        {
            case 1:
                setContentView(R.layout.activity_boat);
                break;
            case 2:
                setContentView(R.layout.activity_bow);
                break;
            case 3:
                setContentView(R.layout.activity_bridge);
                break;
            case 4:
                setContentView(R.layout.activity_chair);
                break;
            case 5:
                setContentView(R.layout.activity_child);
                break;
            case 6:
                setContentView(R.layout.activity_cobblers);
                break;
            case 7:
                setContentView(R.layout.activity_cow);
                break;
        }
        button=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.time);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning)
                {
                    stopTimer();
                }
                else
                {
                    startTimer();
                }
            }
        });

    }

    private void startTimer() {

        final CharSequence value1=mtextview.getText();
        String num1=value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);
        final int number=Integer.valueOf(num2)*60+Integer.valueOf(num3);
        mtimeleft=number*1000;
        countDownTimer=new CountDownTimer(mtimeleft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mtimeleft=millisUntilFinished;
                updateTime();

            }

            @Override
            public void onFinish() {
                int newvalue=Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7)
                {
                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("Value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else
                {
                    newvalue=1;
                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("Value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();
        button.setText("PAUSE");
        mTimerRunning=true;

    }

    private void updateTime() {

        int minutes=(int) mtimeleft/60000;
        int seconds=(int) mtimeleft%60000 / 1000;
        String timelefttext="";
        if(minutes<10)
        {
            timelefttext="0";
        }
        timelefttext=timelefttext+minutes+":";
        if(seconds<10)
        {
            timelefttext+="0";

        }
        timelefttext+=seconds;
        mtextview.setText(timelefttext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopTimer();
        finish();
    }

    private void stopTimer() {
        if (countDownTimer != null && mTimerRunning) {
            countDownTimer.cancel();
            mTimerRunning = false;
        }
        button.setText("Start");
    }
}
