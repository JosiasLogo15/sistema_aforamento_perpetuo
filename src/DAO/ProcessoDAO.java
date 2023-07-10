package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Model.Cemiterio;
import Model.Processo;

public class ProcessoDAO implements interfaceDAO<Processo>{
	private Connection conn = null;
	private Conexao conexao = new Conexao();
	private PreparedStatement stmt;
	private String sql;
	private ResultSet rs;
	private java.util.Date data;
	private java.sql.Date datasql;
	private Cemiterio cemiterio;
	
	@Override
	public void save(Processo processo) {
		
		try {
		sql = "INSERT INTO processo(requerente, medida, falecido, data_entrada, "
				+ "endereco, bairro, quadra, estaca, situacao, rg, nacionalidade, folha, livro, codigo_cemiterio)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, processo.getRequerente());
		stmt.setString(2, processo.getMedida());
		stmt.setString(3, processo.getFalecido());
		
		data = processo.getDataEntrada();
		datasql = new java.sql.Date(data.getDate());
		
		stmt.setDate(4, datasql);
		stmt.setString(5, processo.getEndereco());
		stmt.setString(6, processo.getBairro());
		stmt.setString(7, processo.getQuadra());
		stmt.setString(8, processo.getEstaca());
		stmt.setString(9, processo.getSituacao());
		stmt.setString(10, processo.getRg());
		stmt.setString(11, processo.getNacionalidade());
		stmt.setString(12, processo.getFolha());
		stmt.setString(13, processo.getLivro());
		stmt.setString(14, processo.getCodigoCemiterio());
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao salvar o registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				//Escrever log no arquivo de log
			}
		}
		
	}

	@Override
	public void update(Processo processo) {
		try {
			sql = "UPDATE processo SET requerente=?, medida=?, falecido=?, data_entrada=?, "
					+ "endereco=?, bairro=?, quadra=?, estaca=?, situacao=?, rg=?, "
					+ "nacionalidade=?, folha=?, livro=?, codigo_cemiterio=? WHERE numero_processo = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, processo.getRequerente());
			stmt.setString(2, processo.getMedida());
			stmt.setString(3, processo.getFalecido());
			
			data = processo.getDataEntrada();
			datasql = new java.sql.Date(data.getDate());
			
			stmt.setDate(4, datasql);
			stmt.setString(5, processo.getEndereco());
			stmt.setString(6, processo.getBairro());
			stmt.setString(7, processo.getQuadra());
			stmt.setString(8, processo.getEstaca());
			stmt.setString(9, processo.getSituacao());
			stmt.setString(10, processo.getRg());
			stmt.setString(11, processo.getNacionalidade());
			stmt.setString(12, processo.getFolha());
			stmt.setString(13, processo.getLivro());
			stmt.setString(14, processo.getCodigoCemiterio());
			stmt.setInt(15, processo.getNumeroProcesso());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		
	}

	@Override
	public void delete(Processo processo) {
		try {
		sql = "DELETE FROM processo WHERE numero_processo = ?";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, processo.getNumeroProcesso());
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao apagar o registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
	}

	@Override
	public List<Processo> findAll() {
		List<Processo> listaProcessos = null;
		try {
			sql = "SELECT * FROM  processo";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Processo processo = new Processo();
				processo.setRequerente(rs.getString("requerente"));
				processo.setMedida(rs.getString("medida"));
				processo.setFalecido(rs.getString("falecido"));
				processo.setDataEntrada(rs.getDate("data_entrada"));
				processo.setEndereco(rs.getString("endereco"));
				processo.setBairro(rs.getString("bairro"));
				processo.setQuadra(rs.getString("quadra"));
				processo.setEstaca(rs.getString("estaca"));
				processo.setSituacao(rs.getString("situacao"));
				processo.setRg(rs.getString("rg"));
				processo.setNacionalidade(rs.getString("nacionalidade"));
				processo.setFolha(rs.getString("folha"));
				processo.setLivro(rs.getString("livro"));
				listaProcessos.add(processo);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazer as buscas dos registros:" + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		return listaProcessos;
	}

	@Override
	public Processo findById(int codigo) {
		Processo processo = new Processo();
		try {
			sql = "SELECT * FROM processo WHERE numero_processo = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();
			processo.setRequerente(rs.getString("requerente"));
			processo.setMedida(rs.getString("medida"));
			processo.setFalecido(rs.getString("falecido"));
			processo.setDataEntrada(rs.getDate("data_entrada"));
			processo.setEndereco(rs.getString("endereco"));
			processo.setBairro(rs.getString("bairro"));
			processo.setQuadra(rs.getString("quadra"));
			processo.setEstaca(rs.getString("estaca"));
			processo.setSituacao(rs.getString("situacao"));
			processo.setRg(rs.getString("rg"));
			processo.setNacionalidade(rs.getString("nacionalidade"));
			processo.setFolha(rs.getString("folha"));
			processo.setLivro(rs.getString("livro"));
			processo.setCodigoCemiterio(rs.getString("codigo_cemiterio"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao fazer a busca do registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		return processo;
	}

}
