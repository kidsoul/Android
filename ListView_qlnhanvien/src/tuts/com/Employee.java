package tuts.com;

public class Employee {

	
	@Override
	public String toString() {
		return "Employee [id_emp=" + id_emp + ", name_emp=" + name_emp + "]";
	}
	public boolean isSex_emp() {
		return sex_emp;
	}
	public void setSex_emp(boolean sex_emp) {
		this.sex_emp = sex_emp;
	}
	public String getId_emp() {
		return id_emp;
	}
	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}
	public String getName_emp() {
		return name_emp;
	}
	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}
	String id_emp, name_emp;
	boolean sex_emp;
	
	
	
}
