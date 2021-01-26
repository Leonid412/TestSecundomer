package com.example.myapplication;

import android.widget.EditText;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class TimeRun implements Runnable {

    private EditText screen;
    private final SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");    //создаю форматер дату, с помощью которого буду выводить время

    public TimeRun(EditText screen) {
        this.screen = screen;
    }

    @Override
    public void run() {
        while (MainActivity.isCounterRun()){                 // пока флаг "запущен ли секундомер", делай
            //MainActivity.setCounter(new Date().getTime() - MainActivity.getCounterStart());
            screen.setText((formatter.format(new Date().getTime() - MainActivity.getCounterStart())));
                try {
                    TimeUnit.MILLISECONDS.sleep(1);                     //ЖДЕМ
                }catch (InterruptedException e) {e.printStackTrace();}

        }

    }
}
