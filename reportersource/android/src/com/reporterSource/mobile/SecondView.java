package com.reporterSource.mobile;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class SecondView extends Activity implements OnItemClickListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.shitview);
		
		ListView queryList = (ListView) findViewById(R.id.querylistview);
		RSListAdapter adapter = new RSListAdapter(this);
		queryList.setAdapter(adapter);
		
		queryList.setOnItemClickListener(this);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, ReporterSourceActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public void onItemClick(AdapterView<?> aView, View view, int pos, long id) {
		TextView tag = (TextView) view.findViewById(R.id.tvQueryTag);
		TextView sub = (TextView) view.findViewById(R.id.tvQuerySubject);
		String tagText = tag.getText().toString();
		String subText = sub.getText().toString();
		
		Intent intent = new Intent(this, Viewquery.class);
		intent.putExtra("tag", tagText);
		intent.putExtra("sub", subText);
		
		startActivity(intent);
		
	}
}
