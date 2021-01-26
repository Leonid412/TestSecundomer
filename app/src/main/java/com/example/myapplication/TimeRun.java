package com.example.myapplication;

import android.util.Log;
import android.widget.EditText;
import java.util.concurrent.TimeUnit;


public class TimeRun implements Runnable {

    private static final String TAG = "myLogs";
    private long schetchik;
    private EditText screen;

    public TimeRun(EditText screen) {
        this.screen = screen;
    }

    @Override
    public void run() {
        MainActivity.setCounterRun(true);
        while (MainActivity.isCounterRun()){
            schetchik = MainActivity.getCounter();
            Log.d(TAG, String.valueOf(schetchik));
            MainActivity.setCounter(MainActivity.getCounter() + 1);
            screen.setText(String.valueOf(schetchik));
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
