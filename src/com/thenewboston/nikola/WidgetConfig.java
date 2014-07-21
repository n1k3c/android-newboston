package com.thenewboston.nikola;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class WidgetConfig extends Activity implements android.view.View.OnClickListener {
	
	EditText info;
	AppWidgetManager awm;
	Context c;
	int awId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widgetconfig);
		Button b = (Button) findViewById(R.id.bwidgetconfig);
		b.setOnClickListener(this);
		c = WidgetConfig.this;
		info = (EditText) findViewById(R.id.etwidgetconfig);
		// Getting info about the widget that Launched this Activity
		Intent i = getIntent();
		Bundle extras = i.getExtras();
		if (extras != null) {
			awId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
		} else {
			finish();
		}
		awm = AppWidgetManager.getInstance(c);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String e = info.getText().toString();
		
		RemoteViews views = new RemoteViews(c.getPackageName(), R.layout.widget);
		views.setTextViewText(R.id.tvConfigInput, e);
		
		Intent in = new Intent(c, Splash.class);
		PendingIntent pi = PendingIntent.getActivity(c, 0, in, 0);
		views.setOnClickPendingIntent(R.id.bwidgetOpen, pi);	
		awm.updateAppWidget(awId, views);
		Intent result = new Intent();
		result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, awId);
		setResult(RESULT_OK, result);
		finish();
	}

}









