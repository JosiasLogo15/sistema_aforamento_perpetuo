package DAO;

import java.util.List;

public interface interfaceDAO<object> {

	public void save(object object);
	public void update(object object);
	public void delete(object object);
	public List<object> findAll();
	public object findById(int codigo);
	
}
