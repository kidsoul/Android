package tuts.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView lv;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lv = (ListView) findViewById(R.id.lvPerson);
		tv = (TextView) findViewById(R.id.tvSelection);

		// final String[] arrName = { "Nam", "Bac", "Huy" };
		// or
		//
		final String[] arrName = getResources()
				.getStringArray(R.array.my_array);

		ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arrName);

		lv.setAdapter(arrAdapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				tv.setText("position " + arg2 + "; " + "value is "
						+ arrName[arg2]);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
