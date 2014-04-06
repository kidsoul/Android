package tuts.com;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	private EditText etID, etNAME;
	private RadioGroup radSEX;
	private Button butADD;
	private ImageButton imgButDel;
	private ListView lvEmp;
	private MyArray_adapter adapter = null;
	private ArrayList<Employee> arrEmp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etID = (EditText) findViewById(R.id.et_ID);
		etNAME = (EditText) findViewById(R.id.et_NAME);
		radSEX = (RadioGroup) findViewById(R.id.rad_SEX);
		butADD = (Button) findViewById(R.id.but_ADD);
		lvEmp = (ListView) findViewById(R.id.lv_Employees);
		imgButDel = (ImageButton) findViewById(R.id.but_DEL);

		arrEmp = new ArrayList<Employee>();
		adapter = new MyArray_adapter(this, R.layout.layout_custom, arrEmp);
		lvEmp.setAdapter(adapter);

		butADD.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				doADD();
			}
		});
		imgButDel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				doDel();
			}
		});
	}

	public void doADD() {
		String id = etID.getText() + "";
		String name = etNAME.getText() + "";
		Boolean sex = false; // male is false
		if (radSEX.getCheckedRadioButtonId() == R.id.radio0)
			sex = false;
		else
			sex = true;
		Employee emp = new Employee();
		emp.setId_emp(id);
		emp.setName_emp(name);
		emp.setSex_emp(sex);
		// Add to list
		arrEmp.add(emp);
		adapter.notifyDataSetChanged();
		// after added
		etID.setText("");
		etNAME.setText("");
		etID.requestFocus();
	}

	public void doDel() {
		for (int i = lvEmp.getChildCount() - 1; i >= 0; i--) {
			View v = lvEmp.getChildAt(i);
			CheckBox chk = (CheckBox) v.findViewById(R.id.chkItem);
			if(chk.isChecked())
				arrEmp.remove(i);
		}
		
		adapter.notifyDataSetChanged();
	}

}
