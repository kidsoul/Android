package tuts.com;

public class EmployeeFullTime extends Employee {

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public String toString() {
		return super.toString() + "EmployeeFullTime [tinhLuong()="
				+ tinhLuong() + "]";
	}

}
