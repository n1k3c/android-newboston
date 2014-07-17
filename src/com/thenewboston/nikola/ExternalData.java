package com.thenewboston.nikola;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener  {

	private TextView canWrite, canRead;
	private String state;
	boolean canW, canR;
	Spinner spinner;
	String[] paths = {"Music", "Picture", "Download"};
	File path = null;
	EditText saveFile;
	Button confrim, save;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		
		canWrite = (TextView) findViewById(R.id.tvCanWrite);
		canRead = (TextView) findViewById(R.id.tvCanRead);
		confrim = (Button) findViewById(R.id.bConfrimSaveAs);
		save = (Button) findViewById(R.id.bSaveFile);
		
		confrim.setOnClickListener(this);
		save.setOnClickListener(this);
		
		
		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			// read/write
			canWrite.setText("true");
			canRead.setText("true");
			canW = canR = true;
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			// read but can't write
			canWrite.setText("false");
			canRead.setText("true");
			canW = false;
			canR = true;
		} else {
			// can't read and write
			canWrite.setText("false");
			canRead.setText("false");
			canW = canR = false;
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int position = spinner.getSelectedItemPosition();
		switch (position) {
		case 0:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bSaveFile:
			
			break;
		case R.id.bConfrimSaveAs:
			save.setVisibility(View.VISIBLE);
			break;
		}
	}

}
