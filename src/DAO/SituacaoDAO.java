package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Model.Situacao;

public class SituacaoDAO {
	private Conexao conexao = new Conexao();
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	public List<Situacao> findAll() throws SQLException {
		sql = "SELECT * FROM status_pagamento";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		List<Situacao> listaStatus = new ArrayList();
		while(rs.next()) {
			Situacao situacao = new Situacao();
			situacao.setId(rs.getInt("id_status"));
			situacao.setStatus(rs.getString("status_pagamento"));
			listaStatus.add(situacao);
		}
		return listaStatus;
	}

	public Situacao findById(int id) throws SQLException {
		sql = "SELECT * FROM status_pagamento WHERE id_status = ?";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		Situacao situacao = new Situacao();
		if(rs.next()) {
			situacao.setId(rs.getInt("id_status"));
			situacao.setStatus(rs.getString("status_pagamento"));
		}
		return situacao;
	}
}
