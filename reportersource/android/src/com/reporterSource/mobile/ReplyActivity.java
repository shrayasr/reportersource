package com.reporterSource.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ReplyActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reply);
		Button reply = (Button) findViewById(R.id.button1);
		reply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentSecondView = new Intent(getApplicationContext(), SecondView.class);
				intentSecondView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				Toast toast = new Toast(getApplicationContext());
				toast.makeText(getApplicationContext(), "Message sent successfully", Toast.LENGTH_LONG).show();
				startActivity(intentSecondView);
			}
		});
	}

}
