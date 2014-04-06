package tuts.com;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button butClick;
	private TextView tvInfoPerson;
	private ListView lvPerson;
	private EditText etInputPerson;
	private ArrayAdapter<String> arrAdapter = null;
	private ArrayList<String> arrPerson = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		butClick = (Button) findViewById(R.id.button1);
		tvInfoPerson = (TextView) findViewById(R.id.tvInfo);
		lvPerson = (ListView) findViewById(R.id.lvPerson);
		etInputPerson = (EditText) findViewById(R.id.editText1);

		arrPerson = new ArrayList<String>();
		arrAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arrPerson);
		lvPerson.setAdapter(arrAdapter);

		butClick.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					arrPerson.add(etInputPerson.getText() + "");
					arrAdapter.notifyDataSetChanged();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				tvInfoPerson.setText("Position: " + arg2 + " Value: "
						+ arrPerson.get(arg2));

			}

		});
		lvPerson.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				arrPerson.remove(arg2);
				arrAdapter.notifyDataSetChanged();
				return false;
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
