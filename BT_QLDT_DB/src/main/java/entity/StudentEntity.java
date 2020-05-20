package entity;

public class StudentEntity extends PersonEntity {
    private Long classroomId;
    private String classroomName;
    private String ministryName;
    private String note;

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getMinistryName() {
        return ministryName;
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }
    
    public String showStudent() {
		return String.format("%-15s%-15s%-10s%-20s", getFirstName(), getLastName(), classroomName, ministryName);
	}
}
