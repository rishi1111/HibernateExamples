package lti.ex6;

public class Employee {

	private int empno;
	private String name;
	private double salary;
	private Department dept;
	
	public Employee() {
		
	}
	
	public Employee(int empno, String name, double salary, Department dept) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
