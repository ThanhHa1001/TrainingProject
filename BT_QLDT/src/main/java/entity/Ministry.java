package entity;

public class Ministry extends Person {
	
	@Override
	public String toString() {
		String toString = "Ministry [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + "]";
		return toString;
	}
}
