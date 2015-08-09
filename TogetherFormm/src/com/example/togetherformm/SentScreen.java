package com.example.togetherformm;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SentScreen extends Activity {
	
Button btnSendAgain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sent_screen);
		
		btnSendAgain = (Button) findViewById(R.id.btnSendAgain);
		btnSendAgain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent startFormActivity = new Intent(SentScreen.this, FormActivity.class);
				startActivity(startFormActivity);
			}
		});		
	}
}
