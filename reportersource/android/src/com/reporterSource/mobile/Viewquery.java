package com.reporterSource.mobile;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Viewquery extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewquery);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		TextView tvTag = (TextView) findViewById(R.id.tag);
		TextView tvSub = (TextView) findViewById(R.id.subject);
		tvTag.setText(getIntent().getStringExtra("tag"));
		tvSub.setText(getIntent().getStringExtra("sub"));
		
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
		
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home:
			Intent intent = new Intent(this,SecondView.class);
			intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		case R.id.menu_reply:
			Intent replyIntent = new Intent(this,ReplyActivity.class);
			startActivity(replyIntent);
			return true;
		default: return super.onOptionsItemSelected(item); 
			
		}
		
	}
}
