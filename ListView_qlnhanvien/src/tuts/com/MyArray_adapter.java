package tuts.com;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArray_adapter extends ArrayAdapter<Employee> {

	private Activity context = null;
	private ArrayList<Employee> arrEmp = null;
	private int layoutId;

	public MyArray_adapter(Activity context, int layoutID,
			ArrayList<Employee> arr) {
		super(context, layoutID, arr);
		this.context = context;
		this.arrEmp = arr;
		this.layoutId = layoutID;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = context.getLayoutInflater();
		convertView = inflater.inflate(layoutId, null);
		if (arrEmp.size() > 0 && position >= 0) {

			final TextView tvItem = (TextView) convertView
					.findViewById(R.id.tvItem);
			final ImageView imgItem = (ImageView) convertView
					.findViewById(R.id.imgItem);

			final Employee emp = arrEmp.get(position);

			tvItem.setText(emp.toString());
			if (emp.isSex_emp()) {
				imgItem.setImageResource(R.drawable.male);
			} else {
				imgItem.setImageResource(R.drawable.female);
			}

		}
		return convertView;
	}

}
