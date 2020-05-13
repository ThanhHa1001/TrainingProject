package entity;

public class Person {
	private String personId;
	private String name;
	private Integer age;
	private String address;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String goPartyPublic() {
		return "di quay di e oi - public method";
	}
	
	protected String goPartyProtected() {
		return "di quay di e oi - protected method";
	}
	
	private String goPartyPrivate() {
		return "di quay di e oi - private method";
	}
	
	String goPartyDefault() {
		return "di quay di e oi - default method";
	}
	
}
