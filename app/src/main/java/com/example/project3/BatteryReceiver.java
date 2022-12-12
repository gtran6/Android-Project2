package com.example.project3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {
    TextView batterydetail;

    public BatteryReceiver(TextView batterydetail) {
        this.batterydetail = batterydetail;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int percent = intent.getIntExtra("battery-level", 0);
        if (percent != 0) {
            batterydetail.setText(percent);
        }
    }
}
