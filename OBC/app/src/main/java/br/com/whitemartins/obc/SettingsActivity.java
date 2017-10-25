package br.com.whitemartins.obc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final TextView textBatteryPercent = (TextView) findViewById(R.id.text_battery_percent);
        final ProgressBar progressBarBatteryPercent = (ProgressBar) findViewById(R.id.battery_progress_bar);
        final TextView currentDate = (TextView) findViewById(R.id.current_date);
        getBatteryLevel(textBatteryPercent, progressBarBatteryPercent);
        getCurrentDateTime(currentDate);
    }

    private void getCurrentDateTime(final TextView currentDate) {
        SimpleDateFormat formatOut = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        currentDate.setText(formatOut.format(Calendar.getInstance().getTime()));
    }

    private void getBatteryLevel(final TextView textBatteryPercent, final ProgressBar progressBarBatteryPercent) {
        BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                context.unregisterReceiver(this);
                int rawlevel = intent.getIntExtra("level", -1);
                int scale = intent.getIntExtra("scale", -1);
                int level = -1;
                if (rawlevel >= 0 && scale > 0) {
                    level = (rawlevel * 100) / scale;
                }
                textBatteryPercent.setText(level + "%");
                progressBarBatteryPercent.setProgress(level);
            }
        };
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelReceiver, batteryLevelFilter);
    }

}
