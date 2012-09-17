package com.reporterSource.mobile;

import java.util.ArrayList;

import android.R.color;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RSListAdapter extends BaseAdapter {

	private ArrayList<String> subjectList;
//	private ArrayList<Integer> tagList;
	private Context appContext;
	public RSListAdapter(Context context) {
		appContext = context;
		subjectList = new ArrayList<String>();
		populateStrings();
	}
	
	private void populateStrings() {
		// populate subjectList & tagList
		subjectList.add("How Parents Balance Entrepreneurship with parenting");
		subjectList.add("Is it Indian Democracy or is it Bueraucracy?");
		subjectList.add("How Android Market is picking up and beating Apple");
		
//		tagList.add(0);
//		tagList.add(1);
//		tagList.add(2);
	}
	
	@Override
	public int getCount() {
		return subjectList.size();
	}

	@Override
	public String getItem(int position) {
		return subjectList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if(view == null){
			LayoutInflater li = (LayoutInflater) appContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = li.inflate(R.layout.querylist_row, null);  
		}
		
		TextView tvSubject = (TextView) view.findViewById(R.id.tvQuerySubject);
		TextView tvTag = (TextView) view.findViewById(R.id.tvQueryTag);
		String subject = this.getItem(position);
		tvTag.setTextColor(appContext.getResources().getColor(android.R.color.white));
		tvSubject.setText(subject);
		if(position == 0){
			tvTag.setText("Parenting");
			View tagView = tvTag;
//			tagView.setBackgroundResource(android.R.color.holo_green_light);
			tagView.setBackgroundColor(appContext.getResources().getColor(android.R.color.holo_blue_dark));
		} else if(position == 1){
			tvTag.setText("Politics");
			View tagView = tvTag;
//			tagView.setBackgroundResource(android.R.color.holo_orange_dark);
			tagView.setBackgroundColor(appContext.getResources().getColor(android.R.color.holo_orange_dark));
		} else{
			tvTag.setText("Business");
			View tagView = tvTag;
//			tagView.setBackgroundResource(android.R.color.holo_green_light);
			tagView.setBackgroundColor(appContext.getResources().getColor(android.R.color.holo_green_light));
		}
		return view;
	}

}
