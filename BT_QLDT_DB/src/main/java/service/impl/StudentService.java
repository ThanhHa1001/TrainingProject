package service.impl;

import java.util.List;

import entity.StudentEntity;
import repository.impl.StudentRepository;
import service.IGenericService;

/**
 * StudentService
 */
public class StudentService implements IGenericService<StudentEntity, Long> {
	private final StudentRepository repository = new StudentRepository();

	public List<StudentEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public StudentEntity findById(Long value) {
		return repository.findById(value);
	}

	@Override
	public int insert(StudentEntity entity) {
		return repository.insert(entity);
	}

	@Override
	public int update(StudentEntity entity) {
		return repository.update(entity);

	}

	@Override
	public int delete(Long value) {
		return repository.delete(value);
	}
	
	public List<StudentEntity> findByMinistryId(Long value) {
		return repository.findByMinistryId(value);
	}
	
	public List<StudentEntity> findByNameOrClass(String value) {
		return repository.findByNameOrClass(value);
	}
}