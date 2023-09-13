package DAO;

import java.sql.SQLException;
import java.util.List;

public interface interfaceDAO<object> {

	public void save(object object) throws SQLException;
	public void update(object object)throws SQLException;
	public void delete(object object) throws SQLException;
	public List<object> findAll() throws SQLException;
	public object findById(int codigo) throws SQLException;
	
}
