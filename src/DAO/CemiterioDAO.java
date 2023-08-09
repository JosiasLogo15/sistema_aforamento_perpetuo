package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Model.Cemiterio;



public class CemiterioDAO implements interfaceDAO<Cemiterio>{
	
	private Connection conn = null;
	private Conexao conexao = new Conexao();
	private PreparedStatement stmt;
	private String sql;
	private ResultSet rs;
	
	@Override
	public void save(Cemiterio cemiterio) {
		try {
		sql = "INSERT INTO cemiterio(nome, endereco, bairro) VALUES (?,?,?)";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, cemiterio.getNome());
		stmt.setString(2, cemiterio.getEndereco());
		stmt.setString(3, cemiterio.getBairro());
		stmt.executeUpdate();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir os dados: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
	}
	@Override
	public void update(Cemiterio cemiterio) {
		try {
			sql = "UPDATE cemiterio SET nome=?, endereco=?, bairro=? WHERE codigo_cemiterio = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cemiterio.getNome());
			stmt.setString(2, cemiterio.getEndereco());
			stmt.setString(3, cemiterio.getBairro());
			stmt.setInt(4,  cemiterio.getCodigoCemiterio());
			stmt.executeUpdate();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazer a alteração: " + e);
		} finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public void delete(Cemiterio cemiterio) {
		try {
			sql = "DELETE FROM cemiterio WHERE codigo_cemiterio = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cemiterio.getCodigoCemiterio());
			stmt.executeUpdate();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o registro: "+ e);
		} finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public List<Cemiterio> findAll() {
		List<Cemiterio> listaCemiterio = new ArrayList();
		try {
			
			sql = "SELECT CODIGO_CEMITERIO, NOME, ENDERECO, BAIRRO FROM cemiterio\r\n"
					+ "GROUP BY CODIGO_CEMITERIO, NOME, ENDERECO, BAIRRO;";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cemiterio cemiterio = new Cemiterio();
				cemiterio.setCodigoCemiterio(rs.getInt("codigo_cemiterio"));
				cemiterio.setNome(rs.getString("nome"));
				cemiterio.setEndereco(rs.getString("endereco"));
				cemiterio.setBairro(rs.getString("bairro"));
				listaCemiterio.add(cemiterio);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os registros " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return listaCemiterio;
	}
	
	public List<Cemiterio> findAllStrange() {
		List<Cemiterio> listaCemiterio = new ArrayList();
		try {
			
			sql = "SELECT  processo.NUMERO_PROCESSO,  processo.REQUERENTE,  processo.MEDIDA,  processo.FALECIDO,  \r\n"
					+ "processo.DATA_ENTRADA,  processo.ENDERECO,  processo.BAIRRO,  processo.QUADRA,  processo.ESTACA,  \r\n"
					+ "processo.SITUACAO,  processo.RG,  processo.CODIGO_CEMITERIO,  processo.NACIONALIDADE \r\n"
					+ "FROM processo join cemiterio WHERE processo.CODIGO_CEMITERIO = cemiterio.CODIGO_CEMITERIO ";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cemiterio cemiterio = new Cemiterio();
				cemiterio.setCodigoCemiterio(rs.getInt("cemiterio.codigo_cemiterio"));
				cemiterio.setNome(rs.getString("cemiterio.nome"));
				cemiterio.setEndereco(rs.getString("cemiterio.endereco"));
				cemiterio.setBairro(rs.getString("cemiterio.bairro"));
				listaCemiterio.add(cemiterio);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os registros " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return listaCemiterio;
	}

	@Override
	public Cemiterio findById(int codigo) {
		Cemiterio cemiterio = new Cemiterio();
		try {
			sql = "SELECT * FROM cemiterio WHERE codigo_cemiterio = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
			cemiterio.setCodigoCemiterio(rs.getInt("codigo_cemiterio"));
			cemiterio.setNome(rs.getString("nome"));
			cemiterio.setEndereco(rs.getString("endereco"));
			cemiterio.setBairro(rs.getString("bairro"));
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao buscar o registro pelo codigo informado " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return cemiterio;
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
