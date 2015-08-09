package com.example.togetherformm;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



public class FormActivity extends Activity {

	Button sendForm;
	RadioGroup rg;
	int selectedId;
	RadioButton selectedBtn;
	ProgressBar pb;
	TextView tvSendProgress;
	Handler handler = new Handler();
	int progresStatus = 0;
	public static boolean netResult = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);

		tvSendProgress = (TextView) findViewById(R.id.tvSendProgress);
		pb = (ProgressBar) findViewById(R.id.pbSending);
		pb.setVisibility(View.INVISIBLE);
		ScrollView scroll = (ScrollView) findViewById(R.id.scrollView1);
		scroll.requestFocus();
		getWindow().setBackgroundDrawableResource(R.drawable.ic_background);
		sendForm = (Button) findViewById(R.id.btnSend);
		sendForm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String formAnswers = null;
				String[] answers = new String[20];
				int count = 0;
				String q1Answer = null;
				String q2Answer = null;
				String q3Answer = null;
				String q4Answer = null;
				String q5Answer = null;
				String q6Answer = null;
				String q7Answer = null;
				String q8Name = null;
				String q8Phone = null;
				String q8Email = null;
				CheckBox check;
				EditText txt;

				StringBuilder build = new StringBuilder();
				rg = (RadioGroup) findViewById(R.id.q1Group);
				selectedId = rg.getCheckedRadioButtonId();
				selectedBtn = (RadioButton) findViewById(selectedId);
				q1Answer = selectedBtn.getText().toString();
				build.append(q1Answer);
				build.append("\n");
				answers[count++] = q1Answer;
				rg = (RadioGroup) findViewById(R.id.q2Group);
				selectedId = rg.getCheckedRadioButtonId();
				selectedBtn = (RadioButton) findViewById(selectedId);
				q2Answer = selectedBtn.getText().toString();
				build.append(q2Answer);
				build.append("\n");
				answers[count++] = q2Answer;
				rg = (RadioGroup) findViewById(R.id.q3Group);
				selectedId = rg.getCheckedRadioButtonId();
				selectedBtn = (RadioButton) findViewById(selectedId);
				q3Answer = selectedBtn.getText().toString();
				build.append(q3Answer);
				build.append("\n");
				answers[count++] = q3Answer;
				rg = (RadioGroup) findViewById(R.id.q4Group);
				selectedId = rg.getCheckedRadioButtonId();
				selectedBtn = (RadioButton) findViewById(selectedId);
				q4Answer = selectedBtn.getText().toString();
				build.append(q4Answer);
				build.append("\n");
				answers[count++] = q4Answer;
				check = (CheckBox) findViewById(R.id.q5a1);
				if (check.isChecked()) {
					if (q5Answer == null)
						q5Answer = check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q5a2);
				if (check.isChecked()) {
					if (q5Answer == null) {
						q5Answer = check.getText().toString();
					} else
						q5Answer += "\n" + check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q5a3);
				if (check.isChecked()) {
					if (q5Answer == null) {
						q5Answer = check.getText().toString();
					} else
						q5Answer += "\n" + check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q5a4);
				if (check.isChecked()) {
					if (q5Answer == null) {
						q5Answer = check.getText().toString();
					} else
						q5Answer += "\n" + check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q5a5);
				if (check.isChecked()) {
					if (q5Answer == null) {
						q5Answer = ((EditText) findViewById(R.id.q5Answer))
								.getText().toString();
					} else
						q5Answer += "\n"
								+ ((EditText) findViewById(R.id.q5Answer))
										.getText().toString();
				}
				build.append(q5Answer);
				build.append("\n");
				answers[count++] = q5Answer;
				rg = (RadioGroup) findViewById(R.id.q6Group);
				selectedId = rg.getCheckedRadioButtonId();
				selectedBtn = (RadioButton) findViewById(selectedId);
				q6Answer = selectedBtn.getText().toString();
				build.append(q6Answer);
				build.append("\n");
				answers[count++] = q6Answer;
				check = (CheckBox) findViewById(R.id.q7a1);
				if (check.isChecked()) {
					if (q7Answer == null)
						q7Answer = check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q7a2);
				if (check.isChecked()) {
					if (q7Answer == null) {
						q7Answer = check.getText().toString();
					} else
						q7Answer += "\n" + check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q7a3);
				if (check.isChecked()) {
					if (q7Answer == null) {
						q7Answer = check.getText().toString();
					} else
						q7Answer += "\n" + check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q7a4);
				if (check.isChecked()) {
					if (q7Answer == null) {
						q7Answer = check.getText().toString();
					} else
						q7Answer += "\n" + check.getText().toString();
				}
				check = (CheckBox) findViewById(R.id.q7a5);
				if (check.isChecked()) {
					if (q7Answer == null) {
						q7Answer = check.getText().toString();
					} else
						q7Answer += "\n" + check.getText().toString();
				}
				build.append(q7Answer);
				build.append("\n");
				answers[count++] = q7Answer;
				txt = (EditText) findViewById(R.id.q8names);
				if ((txt.getText().toString()) != null) {
					q8Name = txt.getText().toString();
				} else {
					q8Name = "No name";
				}
				build.append(q8Name);
				build.append("\n");
				answers[count++] = q8Name;
				txt = (EditText) findViewById(R.id.q8phoneNumber);
				if ((txt.getText().toString()) != null) {
					q8Phone = txt.getText().toString();
				} else {
					q8Phone = "No phone";
				}
				build.append(q8Phone);
				build.append("\n");
				answers[count++] = q8Phone;
				txt = (EditText) findViewById(R.id.q8emailAdress);
				if ((txt.getText().toString()) != null) {
					q8Email = txt.getText().toString();
				} else {
					q8Email = "No email";
				}
				build.append(q8Email);
				build.append("\n");
				answers[count++] = q8Email;
				formAnswers = build.toString();
				MaintainInfo proc = new MaintainInfo(FormActivity.this,
						formAnswers);
				proc.save();

				Toast.makeText(FormActivity.this, "net checked",
						Toast.LENGTH_SHORT).show();
				// Upload up = new Upload();
				// up.execute(answers);

				pb.setVisibility(View.VISIBLE);
				new Thread(new Runnable() {
					public void run() {
						while (progresStatus < 100) {
							progresStatus += 1;
							handler.post(new Runnable() {
								public void run() {
									pb.setProgress(progresStatus);
									tvSendProgress.setText("Sending answers: "
											+ progresStatus + "%");
								}
							});
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						Intent startSentScreenActivity = new Intent(
								FormActivity.this, SentScreen.class);
						startActivity(startSentScreenActivity);
					}
				}).start();

				Toast.makeText(FormActivity.this, "Answers uploaded",
						Toast.LENGTH_SHORT).show();
				for (int i = 0; i <= 9; i++) {
					Log.d("tag", answers[i]);
				}

				// Intent startSentScreenActivity = new
				// Intent(FormActivity.this,
				// SentScreen.class);
				// startActivity(startSentScreenActivity);
			}
		});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {

		View v = getCurrentFocus();
		boolean ret = super.dispatchTouchEvent(event);
		if (v instanceof EditText) {
			View w = getCurrentFocus();
			int scrcoords[] = new int[2];
			w.getLocationOnScreen(scrcoords);
			float x = event.getRawX() + w.getLeft() - scrcoords[0];
			float y = event.getRawY() + w.getTop() - scrcoords[1];
			if (event.getAction() == MotionEvent.ACTION_UP
					&& (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w
							.getBottom())) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getWindow().getCurrentFocus()
						.getWindowToken(), 0);
			}
		}
		return ret;
	}
}
