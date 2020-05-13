package entity;

public class Student extends Person {
	private String studentId;
	private String classes;
	private Integer point;

	public Student() {

	}

	public Student(String studentId, String classes, Integer point) {
		this.studentId = studentId;
		this.classes = classes;
		this.point = point;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getTeacherNamePublic() {
		return "Co giao ten la co giao - public method";
	}
	
	protected String getTeacherNameProtected() {
		return "Co giao ten la co giao - protected method";
	}
	
	private String getTeacherNamePrivate() {
		return "Co giao ten la co giao - private method";
	}
	
	String getTeacherNameDefault() {
		return "Co giao ten la co giao - default method";
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", classes=" + classes + ", point=" + point + "]";
	}
}
