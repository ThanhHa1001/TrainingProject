package entity;

public class MinistryEntity extends PersonEntity {
	private String password;
	private String classroomName;
	private Long role;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public String showMinistry() {
		return String.format("%-15s%-15s%-30s%-20s", getFirstName(), getLastName(), getEmail(), getPhone());
	}
}
