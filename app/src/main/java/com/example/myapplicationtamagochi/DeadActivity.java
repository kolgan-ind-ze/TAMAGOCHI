package com.example.myapplicationtamagochi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.example.myapplicationtamagochi.data.DBManager;
import com.example.myapplicationtamagochi.data.TimeClass;

public class DeadActivity extends AppCompatActivity {
    TextView time, bestTime;
    String key = "key";
    String secondsLife = "";
    DBManager dbM;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);
        dbM = new DBManager(this);
        dbM.openDb();
        time = findViewById(R.id.timeLifeTamagochi);
        bestTime = findViewById(R.id.bestTime);
        Bundle arguments = getIntent().getExtras();
        secondsLife = arguments.get("TIME").toString();
        TimeClass timeR = new TimeClass();
        int recordTime = Integer.parseInt(secondsLife);
        timeR.setSeconds(recordTime);
        dbM.addRecord(timeR);
        time.setText("Текущее время: \n" + timeToString(Integer.parseInt(secondsLife)));
        checkBestTime();
    }

    @SuppressLint("SetTextI18n")
    public void checkBestTime(){
        if (!dbM.checkEmpty()){
            bestTime.setText(secondsLife);
        }
        else{
            int maxSecond = dbM.compareTime();

            bestTime.setText("Рекорд: " + timeToString(maxSecond));

        }
    }

    @SuppressLint("DefaultLocale")
    public String timeToString(int secondsAlive) {
        long hour = secondsAlive / 3600,
                min = secondsAlive / 60 % 60,
                sec = secondsAlive / 1 % 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbM.closeDb();
    }
}