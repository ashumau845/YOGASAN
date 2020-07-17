package com.example.yogasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        newArray=new int[]{
                R.id.boatpose,R.id.bowpose,R.id.bridgepose,R.id.chairpose,
                R.id.childpose,R.id.cobblerspose,R.id.cowpose
        };

    }
    public void ImageButtononClicked(View view)
    {
        for (int i=0;i<newArray.length;i++)
        {
            if(view.getId()==newArray[i])
            {
                int value=i+1;
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("Value",String.valueOf(value));
                startActivity(intent);
            }

        }
    }
}
