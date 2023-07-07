package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
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
		sql = "INSER INTO cemiterio(nome, endereco, bairro) VALUE (?,?,?)";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, cemiterio.getNome());
		stmt.setString(2, cemiterio.getEndereco());
		stmt.setString(3, cemiterio.getBairro());
		stmt.executeQuery();
		JOptionPane.showMessageDialog(null, "");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir os dados: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (Exception e2) {
				//Escrever Log no arquivo de Log
			}
		}
	}
	@Override
	public void update(Cemiterio cemiterio) {
		try {
			sql = "ALTER TABLE cemiterio SET nome=?, endereco=?, bairro=?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cemiterio.getNome());
			stmt.setString(2, cemiterio.getEndereco());
			stmt.setString(3, cemiterio.getBairro());
			stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazer a alteração: " + e);
		} finally {
			try {
				conexao.fecharConexao(conn);
			} catch (Exception e2) {
				//Escrever Log no arquivo de Log
			}
		}
		
	}

	@Override
	public void delete(Cemiterio cemiterio) {
		try {
			sql = "DELETE FROM cemiterio WHERE codigo_cemiterio = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cemiterio.getCodigoCemiterio());
			stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Cemiterio deletado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o registro: "+ e);
		} finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		
	}

	@Override
	public List<Cemiterio> findAll() {
		List<Cemiterio> listaCemiterio = null;
		try {
			
			sql = "SELECT * FROM cemiterio";
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
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				//Escrever log no arquivo de log
			}
		}
		return listaCemiterio;
	}

	@Override
	public Cemiterio findById(int codigo) {
		Cemiterio cemiterio = new Cemiterio();
		try {
			
			sql = "SELECT * FROM cemiterio WHERE codigo_cemiterio=?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cemiterio.getCodigoCemiterio());
			rs = stmt.executeQuery();
			
			cemiterio.setCodigoCemiterio(rs.getInt("codigo_cemiterio"));
			cemiterio.setNome(rs.getString("nome"));
			cemiterio.setEndereco(rs.getString("endereco"));
			cemiterio.setBairro(rs.getString("bairro"));
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao buscar o registro pelo codigo informado" + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				//Escrever log no arquivo de log
			}
		}
		return cemiterio;
	}

}
