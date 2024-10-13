package com.example.botones;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CargaActivity extends AppCompatActivity {

    private TextView CargaTextView;
    private long timeLeftInMillis = 5000; // 5 segundos de cuenta regresiva

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espera_screen);

        CargaTextView = findViewById(R.id.CargaTextView);

        startCountDown();
    }

    private void startCountDown() {
        new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(CargaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    private void updateTimer() {
        int seconds = (int) (timeLeftInMillis / 1000);
        CargaTextView.setText(String.valueOf(seconds));
    }
}
