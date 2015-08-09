package com.example.togetherformm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import android.os.AsyncTask;

public class Upload extends AsyncTask<String, Void, Void> {
	
	URL url;
	HttpURLConnection conn;

	@Override
	protected Void doInBackground(String... params) {

		try {
			int count = 0;
			url = new URL(
					"https://docs.google.com/forms/d/1njzK6pONDGReCSmbGNR5WDEl22Hm2ZNoJkci2PRdlGk/formResponse");
			String data = "entry_1818793480="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_1891970664="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_826907225="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_601462569="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_270344351="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_430702408="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_140747848="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_1226443242="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_449304617="
					+ URLEncoder.encode(params[count++], "UTF-8") + "&"
					+ "entry_1542401331="
					+ URLEncoder.encode(params[count++], "UTF-8");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setFixedLengthStreamingMode(data.getBytes().length);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty( "charset", "utf-8");
			byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.write(dataBytes);
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;	
	}
}