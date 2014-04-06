package tuts.com;

public class EmployeePartTime extends Employee {

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return 150;
	}

	@Override
	public String toString() {
		return super.toString() + "EmployeePartTime [tinhLuong()="
				+ tinhLuong() + "]";
	}

}
