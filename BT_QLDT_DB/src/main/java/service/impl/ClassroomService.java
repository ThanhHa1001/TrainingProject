package service.impl;

import java.util.List;

import entity.ClassroomEntity;
import repository.impl.ClassroomRepository;
import service.IGenericService;

public class ClassroomService implements IGenericService<ClassroomEntity, Long> {
	ClassroomRepository classroomRepository = new ClassroomRepository();

	@Override
	public List<ClassroomEntity> findAll() {
		return classroomRepository.findAll();
	}

	@Override
	public ClassroomEntity findById(Long value) {
		return classroomRepository.findById(value);
	}

	public List<ClassroomEntity> findByMinistryId(Long value) {
		return classroomRepository.findByMinistryId(value);
	}

	@Override
	public int insert(ClassroomEntity entity) {
		if (!classroomRepository.isClassroomExist(entity.getName())) {
			if (classroomRepository.insert(entity) == 1) {
				return 1;
			}
		}

		return -1;

	}

	@Override
	public int update(ClassroomEntity entity) {
		return classroomRepository.update(entity);
	}

	@Override
	public int delete(Long value) {
		return classroomRepository.delete(value);
	}
}