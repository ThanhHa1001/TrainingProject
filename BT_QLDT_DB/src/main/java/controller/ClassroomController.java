package controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.ClassroomEntity;
import entity.MinistryEntity;
import util.InputUtil;

public class ClassroomController extends BaseController {
	Logger logger = LoggerFactory.getLogger(ClassroomController.class);
	
	public void showClassroomList(Long ministryId) {
		System.out.println("\n============Danh sách lớp==============");
		List<ClassroomEntity> classrooms = getClassroomService().findAll();
		System.out.printf("%-5s%-15s%-15s%-15s", "ID", "Name", "Ministry ID", "Ministry Name");
		for (ClassroomEntity classroomEntity : classrooms) {
			System.out.printf("\n%-5s%-15s%-15s%-15s", classroomEntity.getId(), classroomEntity.getName(),
					classroomEntity.getMinistryId(), classroomEntity.getMinistryName());
		}
	}

	public void insertClassroom(Scanner scanner) {
		List<MinistryEntity> ministries = getMinistryService().findAll();
		StringBuilder strMinistry = new StringBuilder("Danh sách giáo vụ: ");
		for (int i = 0; i < ministries.size(); i++) {
			int index = i + 1;
			strMinistry.append("\n(").append(index).append(") ");
			strMinistry.append(ministries.get(i).getFirstName()).append(" ");
			strMinistry.append(ministries.get(i).getLastName());
		}
		strMinistry.append("\nChọn giáo vụ theo danh sách trên ");

		System.out.println("Nhập thông tin lớp bạn muốn thêm mới");
		String name = InputUtil.requireUserInput("Name", scanner);
		
		int ministryID = -1;
		do {
			ministryID = Integer.parseInt(InputUtil.requireUserInput(strMinistry.toString(), scanner));
		} while (ministryID < 0 || ministryID > ministries.size());

		ClassroomEntity classroom = new ClassroomEntity();
		classroom.setName(name);
		classroom.setMinistryId((long) ministryID);
		classroom.setCreatedAt(new Date());
		classroom.setCreatedBy("Admin");

		getClassroomService().insert(classroom);
	}

	public void updateClassroom(Scanner scanner) {
		List<MinistryEntity> ministries = getMinistryService().findAll();
		StringBuilder strMinistry = new StringBuilder("Danh sách giáo vụ: ");
		for (int i = 0; i < ministries.size(); i++) {
			int index = i + 1;
			strMinistry.append("\n(").append(index).append(") ");
			strMinistry.append(ministries.get(i).getFirstName()).append(" ");
			strMinistry.append(ministries.get(i).getLastName());
		}
		strMinistry.append("\nChọn giáo vụ theo danh sách trên ");

		System.out.println("\nDanh sách lớp");
		System.out.println("\n============Danh sách lớp==============");
		List<ClassroomEntity> classrooms = getClassroomService().findAll();
		int size = classrooms.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + classrooms.get(i).showClassroom());
		}
		boolean loop = false;
		int index;

		do {
			System.out.println("Chọn lớp học bạn muốn cập nhật thông tin(1 -> " + classrooms.size() + "): ");
			index = scanner.nextInt();

			if (index > 0 && index <= classrooms.size()) {
				loop = false;
			} else {
				loop = true;
			}
		} while (loop);

		// Phan tu trong mang bat dau tu 0
		--index;
		ClassroomEntity classroom = classrooms.get(index);

		System.out.println("Chỉnh sửa thông tin lớp");
		scanner.nextLine();
		String name = InputUtil.userInput("Class name", classroom.getName(), scanner);

		int ministryID = classroom.getMinistryId().intValue();
		do {
			ministryID = Integer.parseInt(InputUtil.requireUserInput(strMinistry.toString(), scanner)) - 1;
		} while (ministryID < 0 || ministryID > ministries.size());
		
		if (name == null || name.isEmpty()) {
			name = classroom.getName();
		}
		classroom.setName(name);
		
		classroom.setMinistryId(ministries.get(ministryID).getId());
		classroom.setModifiedAt(new Date());
		classroom.setModifiedBy("Admin");

		getClassroomService().update(classroom);
	}

	public void deleteClassroom(Scanner scanner) {
		System.out.println("\nDanh sách lớp học");
		List<ClassroomEntity> classrooms = getClassroomService().findAll();
		int size = classrooms.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + classrooms.get(i).showClassroom());
		}
		
		boolean loop = false;
		int index;

		do {
			System.out.println("Chọn học viên bạn muốn xóa(1 -> " + classrooms.size() + "): ");
			index = scanner.nextInt();

			if (index > 0 && index <= classrooms.size()) {
				loop = false;
			} else {
				loop = true;
			}
		} while (loop);

		scanner.nextLine();
		getClassroomService().delete(classrooms.get(index - 1).getId());
	}
}