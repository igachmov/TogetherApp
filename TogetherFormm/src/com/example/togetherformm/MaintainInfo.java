package com.example.togetherformm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import android.content.Context;
import android.widget.Toast;

public class MaintainInfo {

	String data;
	Context context;
	OutputStreamWriter osw;
	InputStream inputStream;

	public MaintainInfo(Context context, String data) {
		try {
			this.context = context;
			this.data = data;
			osw = new OutputStreamWriter(context.openFileOutput("FormAnswers",
					Context.MODE_PRIVATE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			osw.write(data);
			osw.close();
			Toast.makeText(context, "Data saved", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
