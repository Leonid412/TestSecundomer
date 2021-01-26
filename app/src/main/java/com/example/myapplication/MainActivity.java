package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonClear;
    public EditText screenTimer;
    private final SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");   //создаю форматер дату, с помощью которого буду выводить время
    private static long counterStart;                                                      //создаю переменную для начала отсчета
    private long counterStop ;                                                             //создаю переменную для конца отсчета
    private static long counter = 0;                                                       //перемменная для подсчета времени в лонгах
    private static final String TAG = "myLogs";                                            // переменная для Дебага
    private static boolean counterRun = false;                                             // флаг который указывает запущен ли секундомер

    //ГЕТТЕРЫ И СЕТТЕРЫ:
    public static boolean isCounterRun() {return counterRun;}
    public static long getCounterStart() {return counterStart;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {  Log.d(TAG, "приложение запустилось" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonClear = findViewById(R.id.buttonClear);
        screenTimer = findViewById(R.id.editTextTime);

        screenTimer.setText(formatter.format(counter));

        View.OnClickListener startOnClickListener = new View.OnClickListener() {      //создаю лисенер для кнопки Старт
            @Override
            public void onClick(View v) {
                if (!counterRun) {
                    counterStart = new Date().getTime() - counter;
                    counterRun = true;                                               //флаг секундомер запущен

                    TimeRun timeRunStart = new TimeRun(screenTimer);                 //создаю элемент Класса с интерфейсом Runnable, передаю в него Вьюху,в которой будут тикать циферки
                    Thread threadTimeRun = new Thread(timeRunStart);                 //создаю поток , передаю в него объект Класса с интерфейсом Runnable
                    threadTimeRun.start();                                           // запускаю поток
                }
            }
        };
        buttonStart.setOnClickListener(startOnClickListener);                        // вешаю лисенер на кнопку Старт

        View.OnClickListener stopOnClickListener = new View.OnClickListener() {     //создаю лисенер для кнопки Стоп
            @Override
            public void onClick(View v) {
                if (counterRun) {
                    counterRun = false;                                            //флаг секундомер остановлен
                    counterStop = new Date().getTime();
                    counter = counterStop - counterStart;
                }

            }
        };
        buttonStop.setOnClickListener(stopOnClickListener);                       // вешаю лисенер на кнопку Стоп

        View.OnClickListener clearOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Клеар

            @Override
            public void onClick(View v) {
                counterRun = false;
                counter = 0;
                screenTimer.setText(formatter.format(counter));
            }
        };
        buttonClear.setOnClickListener(clearOnClickListener); // вешаю лисенер на кнопку Клеар

    }

}

