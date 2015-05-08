package com.example.activitydemo;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends ActivityGroup implements OnClickListener {
	LinearLayout ll;
	Button btn1, btn2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ll = (LinearLayout) findViewById(R.id.ll);

		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		getstartActivity000(Activity01.class);

	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button1:

			getstartActivity000(Activity01.class);

			break;
		case R.id.button2:

			getstartActivity000(Activity02.class);

			break;

		}
	}

	public void getstartActivity000(Class<?> endActivity) {
		ll.removeAllViews();
		Intent intent = new Intent(this, endActivity);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		Window window = getLocalActivityManager().startActivity("", intent);
		View view = window.getDecorView();
		view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		ll.addView(view);

	}

}
