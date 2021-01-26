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
    private final SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");    //создаю форматер дату, с помощью которого буду выводить время
//    private Date currentTime;                                              //переменная типо Дата указывающая текущее время
    private long counterStart;                                            //создаю переменную для начала отсчета
    private long counterStop ;                                                          //создаю переменную для конца отсчета
    private static long counter = 0;                                                         //перемменная для подсчета времени в лонгах
    private static final String TAG = "myLogs";
    private static boolean counterRun = false;

    public long getCounterStart() {return counterStart;}
    public void setCounterStart(long counterStart) {this.counterStart = counterStart;}
    public long getCounterStop() {return counterStop;}
    public void setCounterStop(long counterStop) {this.counterStop = counterStop;}
    public static long getCounter() {return counter;}
    public static void setCounter(long counter) {MainActivity.counter = counter;}
    public static boolean isCounterRun() {return counterRun;}
    public static void setCounterRun(boolean counterRun) {MainActivity.counterRun = counterRun;}


    @Override
    protected void onCreate(Bundle savedInstanceState) {  Log.d(TAG, "приложение запустилось" );
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

                Log.d(TAG, "1" );
                TimeRun timeRunStart = new TimeRun(screenTimer);
                Log.d(TAG, "2" );
                Thread threadTimeRun = new Thread(timeRunStart);
                Log.d(TAG, "3" );
                threadTimeRun.start();
                Log.d(TAG, "4" );
            }
        };
        buttonStart.setOnClickListener(startOnClickListener); // вешаю лисенер на кнопку Старт

        View.OnClickListener stopOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Стоп
            @Override
            public void onClick(View v) {
                counterRun = false;
                counterStop = new Date().getTime();
                counter = counterStop - counterStart;
                screenTimer.setText(formatter.format(counter));


            }
        };
        buttonStop.setOnClickListener(stopOnClickListener); // вешаю лисенер на кнопку Стоп

        View.OnClickListener clearOnClickListener = new View.OnClickListener() {  //создаю лисенер для кнопки Клеар


            @Override
            public void onClick(View v) {
                counter = 0;
                screenTimer.setText(formatter.format(counter));

                //PrinterMessage printMessage1 = new PrinterMessage(screenTimer,"запускаю ран");
                //Thread threadPrintMessage = new Thread(printMessage1);
                //threadPrintMessage.start();

                //screenTimer.setText("нажали очистить");
            }
        };
        buttonClear.setOnClickListener(clearOnClickListener); // вешаю лисенер на кнопку Клеар

    }

}

