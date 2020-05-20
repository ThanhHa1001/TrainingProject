package entity;

public class ClassroomEntity extends BaseEntity {
	private String name;
	private Long ministryId;
	private String ministryName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMinistryId() {
		return ministryId;
	}

	public void setMinistryId(Long ministryId) {
		this.ministryId = ministryId;
	}

	public String getMinistryName() {
		return ministryName;
	}

	public void setMinistryName(String ministryName) {
		this.ministryName = ministryName;
	}
	
	public String showClassroom() {
		return String.format("%-15s%-20s", getName(), ministryName);
	}
}
