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
			datasql = new java.sql.Date(data.getTime());
			sql = "INSERT INTO aforamento(numero_processo, codigo_prefeito, observacoes, numero_aforamento, data_aforamento, folha, livro, situacao) VALUES(?,?,?,?,?,?,?,?)";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,aforamento.getNumeroProcesso());
			stmt.setInt(2, aforamento.getCodigoPrefeito());
			stmt.setString(3, aforamento.getObservacoes());
			stmt.setInt(4, aforamento.getNumeroAforamento());
			stmt.setDate(5, datasql);
			stmt.setString(6, aforamento.getFolha());
			stmt.setString(7, aforamento.getLivro());
			stmt.setString(8, aforamento.getSituacao());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o aforamento: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		
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

	@Override
	public void update(Aforamento aforamento) {
		try {
			data = aforamento.getDataAforamento();
			datasql = new java.sql.Date(data.getTime());
			conn = conexao.obterConexao();
			sql = "UPDATE aforamento SET codigo_prefeito = ?, observacoes = ?, "
					+ "data_aforamento = ?, folha = ?, livro = ?, situacao = ?  WHERE numero_aforamento = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, aforamento.getCodigoPrefeito());
			stmt.setString(2, aforamento.getObservacoes());
			stmt.setDate(3, datasql);
			stmt.setString(4, aforamento.getFolha());
			stmt.setString(5, aforamento.getLivro());
			stmt.setString(6, aforamento.getSituacao());
			stmt.setInt(7, aforamento.getNumeroAforamento());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o registro: " + e);
		} finally {
			fechaConexoes(conn, stmt, rs);
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
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public List<Aforamento> findAll() {
		List<Aforamento> listaAforamento = new ArrayList<Aforamento>();
		try {
			
			conn = conexao.obterConexao();
			sql = "SELECT * FROM aforamento";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Aforamento aforamento = new Aforamento();
				aforamento.setObservacoes(rs.getString("observacoes"));
				aforamento.setDataAforamento(rs.getDate("data_aforamento"));
				aforamento.setNumeroAforamento(rs.getInt("numero_aforamento"));
				aforamento.setCodigoPrefeito(rs.getInt("codigo_prefeito"));
				aforamento.setNumeroProcesso(rs.getInt("numero_processo"));
				aforamento.setFolha(rs.getString("folha"));
				aforamento.setLivro(rs.getString("livro"));
				aforamento.setSituacao(rs.getString("situacao"));
				listaAforamento.add(aforamento);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os registros: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
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
			
			if(rs.next()) {
			aforamento.setNumeroAforamento(rs.getInt("numero_aforamento"));
			aforamento.setObservacoes(rs.getString("observacoes"));
			aforamento.setDataAforamento(rs.getDate("data_aforamento"));
			aforamento.setNumeroProcesso(rs.getInt("numero_processo"));
			aforamento.setCodigoPrefeito(rs.getInt("codigo_prefeito"));
			aforamento.setFolha(rs.getString("folha"));
			aforamento.setLivro(rs.getString("livro"));
			aforamento.setSituacao(rs.getString("situacao"));
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return aforamento;
	}
	
}
