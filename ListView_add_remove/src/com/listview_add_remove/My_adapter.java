package com.listview_add_remove;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class My_adapter extends ArrayAdapter {

	private int myLayoutId;
	private Activity ct;
	private ArrayList<String> arrStr = null;
	private int pos = -1;
	public My_adapter(Activity context, int resource, ArrayList<String> objects) {
		super(context, resource, objects);
		this.myLayoutId = resource;
		this.ct = context;
		this.arrStr = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ct.getLayoutInflater();
		convertView = inflater.inflate(myLayoutId, null);
		
		if (arrStr.size() > 0 && position >= 0) {
			pos = position;
			TextView tv = (TextView) convertView.findViewById(R.id.tv_show);
			Button but = (Button) convertView.findViewById(R.id.but_remove);
			
			tv.setText(arrStr.get(position));
			but.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					arrStr.remove(pos);
					
				}
			});
		}

		return convertView;
	}
}
