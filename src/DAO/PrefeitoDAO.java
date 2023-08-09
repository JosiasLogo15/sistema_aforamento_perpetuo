package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Model.Prefeito;

public class PrefeitoDAO implements interfaceDAO<Prefeito>{
	private Connection conn;
	private String sql;
	private Conexao conexao = new Conexao();
	private ResultSet rs;
	private PreparedStatement stmt;
	private java.util.Date dataInicio;
	private java.util.Date dataFinal;
	private java.sql.Date datasql;
	
	@Override
	public void save(Prefeito prefeito) {
		try {
			dataInicio = prefeito.getDataInicio();
			datasql = new java.sql.Date(dataInicio.getTime());

			sql = "INSERT INTO prefeito(nome, inicio, final) VALUES(?,?,?)";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,prefeito.getNome());
			stmt.setDate(2, datasql);
			
			dataFinal = prefeito.getDataFinal();
			datasql = new java.sql.Date(dataFinal.getTime());

			stmt.setDate(3, datasql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o aforamento: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}
	
	@Override
	public void update(Prefeito prefeito) {
		try {
			dataInicio = prefeito.getDataInicio();
			datasql = new java.sql.Date(dataInicio.getTime());
			
			conn = conexao.obterConexao();
			sql = "UPDATE prefeito SET nome=?, inicio=?, final=? WHERE codigo_prefeito=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, prefeito.getNome());
			stmt.setDate(2, datasql);
			
			dataFinal = prefeito.getDataFinal();
			datasql = new java.sql.Date(dataFinal.getTime());
			stmt.setDate(3, datasql);
			stmt.setInt(4, prefeito.getCodigoPrefeito());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o registro: " + e);
		} finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public void delete(Prefeito prefeito) {
		try {
			sql = "DELETE FROM prefeito WHERE codigo_prefeito = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, prefeito.getCodigoPrefeito());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public List<Prefeito> findAll() {
		List<Prefeito> listaPrefeitos = new ArrayList<Prefeito>();
		try {
			
			conn = conexao.obterConexao();
			sql = "SELECT * FROM prefeito";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Prefeito prefeito = new Prefeito();
				prefeito.setCodigoPrefeito(rs.getInt("codigo_prefeito"));
				prefeito.setNome(rs.getString("nome"));
				prefeito.setDataInicio(rs.getDate("inicio"));
				prefeito.setDataFinal(rs.getDate("final"));
				listaPrefeitos.add(prefeito);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os registros: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return listaPrefeitos;
	}

	@Override
	public Prefeito findById(int codigo) {
		Prefeito prefeito = new Prefeito();
		try {
			conn = conexao.obterConexao();
			sql = "SELECT * FROM prefeito WHERE codigo_prefeito = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			if(rs.next()) {
			prefeito.setCodigoPrefeito(rs.getInt("codigo_prefeito"));
			prefeito.setNome(rs.getString("nome"));
			prefeito.setDataInicio(rs.getDate("inicio"));
			prefeito.setDataFinal(rs.getDate("final"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return prefeito;
	}
	private void fechaConexoes(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conexao.fecharConexao(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
}
