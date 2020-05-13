package entity;

public class Student extends Person {
	private String className;
	private String note;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String showStudent() {
		return String.format("%-20s%-10s%-35s%-15s", getFullName(), className, email, phone);
	}
	
	@Override
	public String toString() {
		String toString = "Student [firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", className=" + className + ", note=" + note + "]";
		return toString;
	}
}
