package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int secCount;
    private boolean isActivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activateTimer();
    }

    private void activateTimer(){
        final TextView textView = (TextView)findViewById(R.id.textView);
    }

    public void startOnClick(View view){
        isActivate = true;
    }

    public void stopOnClick(View view){
        isActivate = false;
    }

    public void resetOnClick(View view){
        isActivate = false;
        secCount = 0;
    }
}