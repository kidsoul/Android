package tuts.com;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etID, etNAME;
	private RadioGroup rgType;
	private Button butNhap;
	private ListView lv;
	private ArrayAdapter<Employee> arrAdapter;
	private ArrayList<Employee> arrListEmployee;
	private Employee employee;
	private LinearLayout container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		
		arrListEmployee = new ArrayList<Employee>();
		arrAdapter = new EmployeeAdapter(this, R.layout.custom_layout,
				arrListEmployee);
		lv.setAdapter(arrAdapter);

		try {
			butNhap.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					progressNhap();
				}
			});
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	public void init(){
		etID = (EditText) findViewById(R.id.etEmployeeID);
		etNAME = (EditText) findViewById(R.id.etEmployeeName);
		rgType = (RadioGroup) findViewById(R.id.rgType);
		lv = (ListView) findViewById(R.id.lvEmployee);
		butNhap = (Button) findViewById(R.id.butNhap);
	}

	public void progressNhap() {
		int radID = rgType.getCheckedRadioButtonId();
		String id = etID.getText() + "";
		String name = etNAME.getText() + "";

		switch (radID) {
		case R.id.radio0:
			employee = new EmployeeFullTime();
			break;
		case R.id.radio1:
			employee = new EmployeePartTime();
			break;
		default:
			break;
		}

		employee.setId(id);
		employee.setName(name);

		arrListEmployee.add(employee);
		arrAdapter.notifyDataSetChanged();
		lv.setVisibility(View.VISIBLE);
	}

}
