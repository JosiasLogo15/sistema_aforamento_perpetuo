package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import Conexao.Conexao;
import Model.Aforamento;

public class AforamentoDAO implements interfaceDAO<Aforamento> {
	
	private Conexao conexao = new Conexao();
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	@Override
	public void save(Aforamento aforamento) {
		try {
			sql = "INSERT INTO aforamento(observacoes, data_aforamento, numero_processo, codigo_prefeito) VALUES(?,?,?,?)";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,aforamento.getObservacoes());
			stmt.setDate(2, Date(new java.util.Date(aforamento.getDataAforamento())));
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void update(Aforamento object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aforamento object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aforamento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aforamento findById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
