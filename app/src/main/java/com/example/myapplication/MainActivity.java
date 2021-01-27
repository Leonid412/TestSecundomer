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

        screenTimer = findViewById(R.id.editTextTime);
    }

    public void startOnClick(View view) {
        if (!counterRun) {
            counterStart = new Date().getTime() - counter;
            counterRun = true;                                               //флаг секундомер запущен

            TimeRun timeRunStart = new TimeRun(screenTimer);                 //создаю элемент Класса с интерфейсом Runnable, передаю в него Вьюху,в которой будут тикать циферки
            Thread threadTimeRun = new Thread(timeRunStart);                 //создаю поток , передаю в него объект Класса с интерфейсом Runnable
            threadTimeRun.start();                                           // запускаю поток
        }
    }

    public void stopOnClick(View view) {
        if (counterRun) {
            counterRun = false;                                            //флаг секундомер остановлен
            counterStop = new Date().getTime();
            counter = counterStop - counterStart;
        }
    }

    public void resetOnClick(View view) {
        counterRun = false;
        counter = 0;
        screenTimer.setText(formatter.format(counter));

    }
}

