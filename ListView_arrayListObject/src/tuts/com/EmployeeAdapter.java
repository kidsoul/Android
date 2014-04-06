package tuts.com;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

	private Activity con;
	private int layoutID = 0;
	private ArrayList<Employee> arrEmployee = null;

	public EmployeeAdapter(Activity cont, int resource, ArrayList<Employee> objects) {
		super(cont, resource, objects);
		this.con = cont;
		this.layoutID = resource;
		this.arrEmployee = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = con.getLayoutInflater();
		convertView = inflater.inflate(layoutID, null);
		if (position >= 0 && arrEmployee.size() > 0) {
			TextView tv = (TextView) convertView.findViewById(R.id.tv_employee);
			Employee employee = arrEmployee.get(position);
			tv.setText(employee.toString());
		}
		return convertView;
	}

}
