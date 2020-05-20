package controller;

import service.impl.ClassroomService;
import service.impl.MinistryService;
import service.impl.StudentService;

public class BaseController {
	private StudentService studentService = new StudentService();
	private MinistryService ministryService = new MinistryService();
	private ClassroomService classroomService = new ClassroomService();

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public MinistryService getMinistryService() {
		return ministryService;
	}

	public void setMinistryService(MinistryService ministryService) {
		this.ministryService = ministryService;
	}

	public ClassroomService getClassroomService() {
		return classroomService;
	}

	public void setClassroomService(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}
}
