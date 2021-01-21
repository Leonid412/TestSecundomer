package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.text.SimpleDateFormat;
import java.util.Date;
//тест гита


public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonClear;
    private EditText screenTimer;
    private SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");    //создаю форматер дату, с помощью которого буду выводить время
//    private Date currentTime;                                              //переменная типо Дата указывающая текущее время
    private long counterStart;                                            //создаю переменную для начала отсчета
    private long counterStop ;                                                          //создаю переменную для конца отсчета
    private long counter = 0;                                                         //перемменная для подсчета времени в лонгах




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonClear = findViewById(R.id.buttonClear);
        screenTimer = findViewById(R.id.editTextTime);

        screenTimer.setText(formatter.format(counter));

        View.OnClickListener startOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Старт
            @Override
            public void onClick(View v) {
                    counterStart = new Date().getTime() - counter;
                    //screenTimer.setText("нажали старт");
            }
        };
        buttonStart.setOnClickListener(startOnClickListener); // вешаю лисенер на кнопку Старт

        View.OnClickListener stopOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Стоп
            @Override
            public void onClick(View v) {
                counterStop = new Date().getTime();
                counter = counterStop - counterStart;
                screenTimer.setText(formatter.format(counter));

                //screenTimer.setText("нажали стоп");
            }
        };
        buttonStop.setOnClickListener(stopOnClickListener); // вешаю лисенер на кнопку Стоп

        View.OnClickListener clearOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Клеар
            @Override
            public void onClick(View v) {
                counter = 0;
                screenTimer.setText(formatter.format(counter));
                //screenTimer.setText("нажали очистить");
            }
        };
        buttonClear.setOnClickListener(clearOnClickListener); // вешаю лисенер на кнопку Клеар

    }
}