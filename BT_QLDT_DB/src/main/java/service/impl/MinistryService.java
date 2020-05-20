package service.impl;

import java.util.List;

import entity.MinistryEntity;
import repository.impl.MinistryRepository;
import service.IGenericService;
import util.ExceptionUtils;

public class MinistryService implements IGenericService<MinistryEntity, Long>{
	private MinistryRepository repository = new MinistryRepository();
	
	@Override
	public List<MinistryEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public MinistryEntity findById(Long value) {
		return repository.findById(value);
	}

	@Override
	public int insert(MinistryEntity entity) {
		return repository.insert(entity);
	}

	@Override
	public int update(MinistryEntity entity) {
		return repository.update(entity);
	}

	@Override
	public int delete(Long value) {
		try {
			return repository.delete(value);
		} catch (ExceptionUtils e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public boolean checkAccountExist(String email) {
		return repository.isMinistryExist(email);
	}
	
	public boolean signIn(String email, String password) {
		if (repository.isMinistryExist(email)) {
			MinistryEntity entity = repository.findByEmail(email);
			if (entity.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	 
	public MinistryEntity findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
