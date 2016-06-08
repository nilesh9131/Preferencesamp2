package com.neel.www.preferencedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

	public static final int RESULT_SETTINGS = 1;
	TextToSpeech t1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showUserSettings();
	}
	public void onPause(){
		if(t1 !=null){
			t1.stop();
			t1.shutdown();
		}
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.menu_settings:
			//Intent i = new Intent(this, UserSettingActivity.class);
			//Intent i = new Intent(this, FragmentActivty.class);
			Intent i = new Intent(this, HeaderPrefActivity.class);


			startActivityForResult(i, RESULT_SETTINGS);
			break;
			case R.id.menu_settings1:
				//Intent i = new Intent(this, UserSettingActivity.class);
				Intent ifrag = new Intent(this, FragmentActivty.class);
				//Intent i = new Intent(this, HeaderPrefActivity.class);


				startActivityForResult(ifrag, RESULT_SETTINGS);
				break;

			case R.id.menu_settings2:
				Intent iact = new Intent(this, UserSettingActivity.class);
				//Intent i = new Intent(this, FragmentActivty.class);
				//Intent i = new Intent(this, HeaderPrefActivity.class);


				startActivityForResult(iact, RESULT_SETTINGS);
				break;


		}

		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case RESULT_SETTINGS:
			showUserSettings();
			break;

		}

	}
	@Override
	public void onDestroy() {
		// Don't forget to shutdown tts!
		if (t1 != null) {
			t1.stop();
			t1.shutdown();
		}
		super.onDestroy();
	}

	private void showUserSettings() {
		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);

		t1=new TextToSpeech(getApplicationContext(),this);
		StringBuilder builder = new StringBuilder();

		builder.append("\n Username: "
				+ sharedPrefs.getString("prefUsername", "NULL"));

		builder.append("\n Send report:"
				+ sharedPrefs.getBoolean("prefSendReport", false));

		builder.append("\n Sync Frequency: "
				+ sharedPrefs.getString("prefSyncFrequency", "NULL"));

		SharedPreferences prefs = getSharedPreferences(LoginActivity.MyPREFERENCES, MODE_PRIVATE);

		String username=prefs.getString("User", "No name defined");
		builder.append("\nLogin Username: "
				+ username);
		//t1.speak(username, TextToSpeech.QUEUE_FLUSH, null);

		TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);

		settingsTextView.setText(builder.toString());
	}
	private void speakOut() {

		SharedPreferences prefs = getSharedPreferences(LoginActivity.MyPREFERENCES, MODE_PRIVATE);

		String username=prefs.getString("User", "No name defined");
		t1.speak("Welcome "+username, TextToSpeech.QUEUE_FLUSH, null);
	}


	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {

			int result = t1.setLanguage(Locale.US);

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "This Language is not supported");
			} else {
             // speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed!");
		}


	}
}
