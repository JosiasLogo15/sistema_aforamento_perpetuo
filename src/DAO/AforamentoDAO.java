package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.jdesktop.swingx.autocomplete.ListAdaptor;

import Conexao.Conexao;
import Model.Aforamento;
import DAO.ProcessoDAO;

public class AforamentoDAO implements interfaceDAO<Aforamento> {
	
	private Conexao conexao = new Conexao();
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	private java.sql.Date datasql;
	private java.util.Date data = new java.util.Date();
	private ProcessoDAO processoDAO = new ProcessoDAO();
	private PrefeitoDAO prefeitoDAO = new PrefeitoDAO();
	
	
	@Override
	public void save(Aforamento aforamento) {
		try {
			data = aforamento.getDataAforamento();
			datasql = new java.sql.Date(data.getDate());
			sql = "INSERT INTO aforamento(observacoes, data_aforamento, numero_processo, codigo_prefeito) VALUES(?,?,?,?)";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,aforamento.getObservacoes());
			stmt.setDate(2, datasql);
			stmt.setInt(3, processoDAO.findById());
			stmt.setInt(4, prefeitoDAO.findById());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o aforamento: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				//Escrever log no arquivo de log
			}
		}
		
	}
	
	@Override
	public void update(Aforamento aforamento) {
		try {
			data = aforamento.getDataAforamento();
			datasql = new java.sql.Date(data.getDate());
			conn = conexao.obterConexao();
			sql = "UPDATE aforamento SET observacoes = ?, data_aforamento = ?, numero_processo = ?, codigo_prefeito = ? WHERE numero_aforamento = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aforamento.getObservacoes());
			stmt.setDate(2, datasql);
			stmt.setInt(3, processoDAO.findById());
			stmt.setInt(4, prefeitoDAO.findById());
			stmt.setInt(5, aforamento.getNumeroAforamento());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o registro: " + e);
		} finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				//Escrever log no arquivo de log
			}
		}
		
	}

	@Override
	public void delete(Aforamento aforamento) {
		try {
			sql = "DELETE FROM aforamento WHERE numero_aforamento = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, aforamento.getNumeroAforamento());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrver log no arquivo de log
			}
		}
		
	}

	@Override
	public List<Aforamento> findAll() {
		List<Aforamento> listaAforamento = null;
		try {
			
			conn = conexao.obterConexao();
			sql = "SELECT * FROM aforamento";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Aforamento aforamento = new Aforamento();
				aforamento.setObservacoes(rs.getString("observacoes"));
				aforamento.setDataAforamento(rs.getDate("data_aforamento"));
				aforamento.setNumeroAforamento(rs.getInt("numero_processo"));
				aforamento.setCodigoPrefeito(rs.getInt("codigo_prefeito"));
				listaAforamento.add(aforamento);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os registros: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		return listaAforamento;
	}

	@Override
	public Aforamento findById(int codigo) {
		Aforamento aforamento = new Aforamento();
		try {
			conn = conexao.obterConexao();
			sql = "SELECT * FROM aforamento WHERE numero_aforamento = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			aforamento.setCodigoPrefeito(rs.getInt("numero_aforamento"));
			aforamento.setObservacoes(rs.getString("observacoes"));
			aforamento.setDataAforamento(rs.getDate("data_aforamento"));
			aforamento.setNumeroAforamento(rs.getInt("numero_processo"));
			aforamento.setCodigoPrefeito(rs.getInt("codigo_prefeito"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		return aforamento;
	}
	
}
