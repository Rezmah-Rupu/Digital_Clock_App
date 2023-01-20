package edu.ewubd.digital_clock_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.text.format.Time;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    TextView clock_time;
    Button exit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mHandler = new Handler();

        exit = findViewById(R.id.btn_exit);

        // clock_time = findViewById(R.id.count);
        // start.setOnClickListener(v->startTask());

        exit.setOnClickListener(v -> finish());

        final Thread thread = new Thread() {

            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView clock_time = (TextView) findViewById(R.id.count);

                                long date = System.currentTimeMillis();

                                SimpleDateFormat sf = new SimpleDateFormat(" HH:mm:ss");
                                clock_time.setText(sf.format(date));
                                // update TextView here!
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
            thread.start();
        }

/*
    private void updateStatus() {
        String time = "HH:mm:ss";
        clock_time.setText(String.valueOf(time));
    }
    */
}