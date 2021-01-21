package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Time;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonClear;
    private EditText screenTimer;
    private Date counter = new Date() ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonClear = findViewById(R.id.buttonClear);
        screenTimer = findViewById(R.id.editTextTime);


        screenTimer.setText(counter.toString());

        View.OnClickListener startOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Старт
            @Override
            public void onClick(View v) {
                screenTimer.setText("нажали старт");
            }
        };
        buttonStart.setOnClickListener(startOnClickListener); // вешаю лисенер на кнопку Старт

        View.OnClickListener stopOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Стоп
            @Override
            public void onClick(View v) {
                screenTimer.setText("нажали стоп");
            }
        };
        buttonStop.setOnClickListener(stopOnClickListener); // вешаю лисенер на кнопку Стоп

        View.OnClickListener clearOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Клеар
            @Override
            public void onClick(View v) {

                screenTimer.setText("нажали очистить");
            }
        };
        buttonClear.setOnClickListener(clearOnClickListener); // вешаю лисенер на кнопку Клеар

    }
}