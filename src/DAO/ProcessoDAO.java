package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		sql = "INSERT INTO processo(numero_processo, requerente, medida, falecido, data_entrada, "
				+ "endereco, bairro, quadra, estaca, rg, nacionalidade,  codigo_cemiterio)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, processo.getNumeroProcesso());
		stmt.setString(2, processo.getRequerente());
		stmt.setString(3, processo.getMedida());
		stmt.setString(4, processo.getFalecido());
		
		data = processo.getDataEntrada();
		datasql = new java.sql.Date(data.getTime());
		
		stmt.setDate(5, datasql);
		stmt.setString(6, processo.getEndereco());
		stmt.setString(7, processo.getBairro());
		stmt.setString(8, processo.getQuadra());
		stmt.setString(9, processo.getEstaca());
		stmt.setString(10, processo.getRg());
		stmt.setString(11, processo.getNacionalidade());
		stmt.setInt(12, processo.getCodigoCemiterio());
		stmt.executeUpdate();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao salvar o registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public void update(Processo processo) {
		try {
			sql = "UPDATE processo SET requerente=?, medida=?, falecido=?, data_entrada=?, "
					+ "endereco=?, bairro=?, quadra=?, estaca=?, rg=?, "
					+ "nacionalidade=?, codigo_cemiterio=? WHERE numero_processo = ?";
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
			stmt.setString(9, processo.getRg());
			stmt.setString(10, processo.getNacionalidade());
			stmt.setInt(11, processo.getCodigoCemiterio());
			stmt.setInt(12, processo.getNumeroProcesso());
			stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		
	}

	@Override
	public void delete(Processo processo) {
		try {
		sql = "DELETE FROM processo WHERE numero_processo = ?";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, processo.getNumeroProcesso());
		stmt.executeUpdate();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao apagar o registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
	}

	@Override
	public List<Processo> findAll() {
		List<Processo> listaProcessos = new ArrayList<Processo>();
		try {
			sql = "SELECT * FROM  processo";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Processo processo = new Processo();
				processo.setNumeroProcesso(rs.getInt("numero_processo"));
				processo.setRequerente(rs.getString("requerente"));
				processo.setMedida(rs.getString("medida"));
				processo.setFalecido(rs.getString("falecido"));
				processo.setDataEntrada(rs.getDate("data_entrada"));
				processo.setEndereco(rs.getString("endereco"));
				processo.setBairro(rs.getString("bairro"));
				processo.setQuadra(rs.getString("quadra"));
				processo.setEstaca(rs.getString("estaca"));
				processo.setCodigoCemiterio(rs.getInt("codigo_cemiterio"));
				processo.setRg(rs.getString("rg"));
				processo.setNacionalidade(rs.getString("nacionalidade"));

				listaProcessos.add(processo);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazer as buscas dos registros:" + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
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
			if(rs.next()) {
			processo.setNumeroProcesso(rs.getInt("numero_processo"));
			processo.setRequerente(rs.getString("requerente"));
			processo.setMedida(rs.getString("medida"));
			processo.setFalecido(rs.getString("falecido"));
			processo.setDataEntrada(rs.getDate("data_entrada"));
			processo.setEndereco(rs.getString("endereco"));
			processo.setBairro(rs.getString("bairro"));
			processo.setQuadra(rs.getString("quadra"));
			processo.setEstaca(rs.getString("estaca"));
			processo.setRg(rs.getString("rg"));
			processo.setNacionalidade(rs.getString("nacionalidade"));

			processo.setCodigoCemiterio(rs.getInt("codigo_cemiterio"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao fazer a busca do registro: " + e);
		}finally {
			fechaConexoes(conn, stmt, rs);
		}
		return processo;
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
