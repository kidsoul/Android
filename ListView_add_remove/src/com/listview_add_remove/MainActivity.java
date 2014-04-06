package com.listview_add_remove;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private EditText etInput;
	private ListView lv;
	private Button butAdd;
	private ArrayList<String> arrStr = null;
	private My_adapter adapter = null;
	private int pos = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		butAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				arrStr.add(etInput.getText().toString());
				adapter.notifyDataSetChanged();
				etInput.setText("");
			}
		});

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				pos = arg2;
				
			}
		});
		for (int i = lv.getChildCount() - 1; i >= 0; i--) {
			final View v = lv.getChildAt(i);
			Button but = (Button) v.findViewById(R.id.but_remove);
			but.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					arrStr.remove(pos);
				}
			});
		}
		adapter.notifyDataSetChanged();

	}

	public void init() {
		etInput = (EditText) findViewById(R.id.et_input);
		lv = (ListView) findViewById(R.id.lv_main);
		butAdd = (Button) findViewById(R.id.but_add);
		arrStr = new ArrayList<String>();
		adapter = new My_adapter(this, R.layout.custom_layout, arrStr);
		lv.setAdapter(adapter);
	}

}
