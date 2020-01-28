package kr.co.admincamp.dto;


//DTO 
public class Admin {
	
	private int id;
	private String name;
	private String gender;
	private String address;
	private String email;
	private String position;
	private String salary;
	
	public Admin() {
		
	}

	public Admin(String name, String gender, String address, String email, String position, String salary) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.position = position;
		this.salary = salary;
	}
	
	public Admin(int id, String name, String gender, String address, String email, String position, String salary) {
		this(name, gender, address, email, position, salary);
		this.id=id;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
