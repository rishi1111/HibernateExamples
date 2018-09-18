package lti.ex6;

import java.util.Set;

public class Department {

	private int deptno;
	private String name;
	private String location;
	private Set<Employee> employees;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Department(int deptno, String name, String location, Set<Employee> employees) {
		super();
		this.deptno = deptno;
		this.name = name;
		this.location = location;
		this.employees = employees;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
