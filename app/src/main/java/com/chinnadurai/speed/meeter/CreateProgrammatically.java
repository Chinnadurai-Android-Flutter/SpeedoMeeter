package com.chinnadurai.speed.meeter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chinnadurai.speed.meeterlib.AwesomeSpeedometer;
import com.chinnadurai.speed.meeterlib.DeluxeSpeedView;
import com.chinnadurai.speed.meeterlib.ImageSpeedometer;
import com.chinnadurai.speed.meeterlib.PointerSpeedometer;
import com.chinnadurai.speed.meeterlib.RaySpeedometer;
import com.chinnadurai.speed.meeterlib.SpeedView;
import com.chinnadurai.speed.meeterlib.Speedometer;
import com.chinnadurai.speed.meeterlib.TubeSpeedometer;
import com.chinnadurai.speed.meeterlib.components.Indicators.Indicator;

import java.util.Locale;
import java.util.Random;

public class CreateProgrammatically extends AppCompatActivity {

    LinearLayout rootSpeedometer;
    Speedometer speedometer;
    SeekBar seekBar;
    Button ok;
    TextView textSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_programmatically);

        rootSpeedometer = (LinearLayout) findViewById(R.id.root_speedometer);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ok = (Button) findViewById(R.id.ok);
        textSpeed = (TextView) findViewById(R.id.textSpeed);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (speedometer != null)
                    speedometer.speedTo(seekBar.getProgress());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSpeed.setText(String.format(Locale.getDefault(), "%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void addRandomSpeedometer(View view) {
        Random mad = new Random();
        switch (mad.nextInt(7)) {
            case 0:
                speedometer = new SpeedView(this);
                break;
            case 1:
                speedometer = new DeluxeSpeedView(this);
                break;
            case 2:
                speedometer = new AwesomeSpeedometer(this);
                break;
            case 3:
                speedometer = new RaySpeedometer(this);
                break;
            case 4:
                speedometer = new PointerSpeedometer(this);
                break;
            case 5:
                speedometer = new TubeSpeedometer(this);
                break;
            case 6:
                speedometer = new ImageSpeedometer(this);
                speedometer.setIndicator(Indicator.Indicators.HalfLineIndicator);
                speedometer.setIndicatorWidth(speedometer.dpTOpx(5f));
                speedometer.setSpeedTextColor(Color.WHITE);
                speedometer.setUnitTextColor(Color.WHITE);
                ((ImageSpeedometer)speedometer).setImageSpeedometer(R.drawable.for_image_speedometer);
                break;
        }
        rootSpeedometer.removeAllViews();
        rootSpeedometer.addView(speedometer);
    }
}
