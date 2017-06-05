package com.taishi.musicindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.taishi.library.Indicator;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Indicator indicator = (Indicator) findViewById(R.id.indicator);
//		indicator.setBarNum(5); // Set number of bars
// 		indicator.setStepNum(4); // Set number of bar-steps (i.e. if you set 2, only 2 levels of bar-height)
//		indicator.setDuration(5000); //

//		indicator.setBarColor(getResources().getColor(R.color.colorAccent)); // Set a color of bar

	}
}
