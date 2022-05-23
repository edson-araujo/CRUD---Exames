package br.com.soc.sistema.dao.consultas;

import br.com.soc.sistema.dao.Dao;


import br.com.soc.sistema.vo.ConsultaVo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsultaDao extends Dao {

	public List<ConsultaVo> findAllConsultas() {
		StringBuilder query = new StringBuilder(
				"SELECT id_consulta id, nm_exame exame, nm_funcionario funcionario, dt_consulta data ")
				.append("FROM consulta LEFT JOIN exame ON exame.id_exame = consulta.id_exame_consulta ")
				.append("LEFT JOIN funcionario ON funcionario.id_funcionario = consulta.id_funcionario_consulta ")
				.append("ORDER BY dt_consulta");
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()) {
			ConsultaVo vo = null;
			SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
			List<ConsultaVo> consultas = new ArrayList<>();
			while (rs.next()) {
				vo = new ConsultaVo();
				vo.setIdConsulta(rs.getString("id"));
				vo.setNmExame(rs.getString("exame"));
				vo.setNmFuncionario(rs.getString("funcionario"));
				vo.setData(sdt.format(rs.getDate("data")));

				consultas.add(vo);
			}

			return consultas;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public void insertConsulta(ConsultaVo consultaVo) {
		StringBuilder query = new StringBuilder(
				"INSERT INTO consulta (id_exame_consulta, id_funcionario_consulta, dt_consulta) ")
				.append("VALUES (?, ?, ?)");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdExame()));
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdFuncionario()));
			ps.setDate(i++, Date.valueOf(consultaVo.getData()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteConsulta(Integer codigo) {
		StringBuilder query = new StringBuilder("DELETE FROM consulta WHERE id_consulta = ?");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setInt(i++, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateConsulta(ConsultaVo consultaVo) {
		StringBuilder query = new StringBuilder(
				"UPDATE consulta SET id_exame_consulta = ?, id_funcionario_consulta = ?, dt_consulta = ? WHERE id_consulta = ?");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdExame()));
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdFuncionario()));
			ps.setDate(i++, Date.valueOf(consultaVo.getData()));
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdConsulta()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ConsultaVo findByCodigo(Integer codigo) {
		StringBuilder query = new StringBuilder("SELECT id_consulta id, id_exame_consulta idExame, nm_exame exame, ")
				.append("id_funcionario_consulta idFuncionario, nm_funcionario funcionario, dt_consulta data FROM ")
				.append("consulta LEFT JOIN exame ON exame.id_exame = consulta.id_exame_consulta LEFT JOIN funcionario ")
				.append("ON funcionario.id_funcionario = consulta.id_funcionario_consulta WHERE id_consulta = ?");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setInt(i, codigo);

			try (ResultSet rs = ps.executeQuery()) {
				ConsultaVo vo = null;
				SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

				while (rs.next()) {
					vo = new ConsultaVo();
					vo.setIdConsulta(rs.getString("id"));
					vo.setIdExame(rs.getString("idExame"));
					vo.setNmExame(rs.getString("exame"));
					vo.setIdFuncionario(rs.getString("idFuncionario"));
					vo.setNmFuncionario(rs.getString("funcionario"));
					vo.setData(sdt.format(rs.getDate("data")));
				}
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ConsultaVo> findConsultasByDate(ConsultaVo consultaVo) {
		StringBuilder query = new StringBuilder("SELECT id_consulta id, id_exame_consulta idExame, nm_exame exame, ")
				.append("id_funcionario_consulta idFuncionario, nm_funcionario funcionario, dt_consulta data FROM ")
				.append("consulta LEFT JOIN exame ON exame.id_exame = consulta.id_exame_consulta LEFT JOIN funcionario ")
				.append("ON funcionario.id_funcionario = consulta.id_funcionario_consulta WHERE dt_consulta BETWEEN (?) AND (?) ")
				.append("ORDER BY dt_consulta");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setDate(i++, Date.valueOf(consultaVo.getDataInicial()));
			ps.setDate(i++, Date.valueOf(consultaVo.getDataFinal()));

			try (ResultSet rs = ps.executeQuery()) {
				ConsultaVo vo = null;
				SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
				List<ConsultaVo> consultas = new ArrayList<>();

				while (rs.next()) {
					vo = new ConsultaVo();
					vo.setIdConsulta(rs.getString("id"));
					vo.setIdExame(rs.getString("idExame"));
					vo.setNmExame(rs.getString("exame"));
					vo.setIdFuncionario(rs.getString("idFuncionario"));
					vo.setNmFuncionario(rs.getString("funcionario"));
					vo.setData(sdt.format(rs.getDate("data")));

					consultas.add(vo);
				}
				return consultas;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ConsultaVo findDuplicada(ConsultaVo consultaVo) {
		StringBuilder query = new StringBuilder(
				"SELECT id_exame_consulta idExame, id_funcionario_consulta idFuncionario, ")
				.append("dt_consulta data FROM consulta LEFT JOIN exame ON exame.id_exame = consulta.id_exame_consulta ")
				.append("LEFT JOIN funcionario ON funcionario.id_funcionario = consulta.id_funcionario_consulta ") //JOIN LEFT TRAZ TODOS OS RESULTADOS DA ESQUERDA COM REFERENCIA DA TABELA DA DIREITA   
				.append("WHERE id_exame_consulta = ? AND id_funcionario_consulta = ? AND dt_consulta = ?");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdExame()));
			ps.setInt(i++, Integer.parseInt(consultaVo.getIdFuncionario()));
			ps.setDate(i++, Date.valueOf(consultaVo.getData()));

			try (ResultSet rs = ps.executeQuery()) {
				ConsultaVo vo = null;
				SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

				while (rs.next()) {
					vo = new ConsultaVo();
					vo.setIdExame(rs.getString("idExame"));
					vo.setIdFuncionario(rs.getString("idFuncionario"));
					vo.setData(sdt.format(rs.getDate("data")));
				}
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ConsultaVo> findMelhoresConsultas(ConsultaVo consultaVo) {
		StringBuilder query = new StringBuilder("SELECT count(id_exame_consulta) qtdExame, nm_exame nmExame ")
				.append("FROM consulta LEFT JOIN exame ON exame.id_exame = consulta.id_exame_consulta ")
				.append("WHERE dt_consulta BETWEEN (?) AND (?) GROUP BY id_exame_consulta ")
				.append("ORDER BY count(id_exame_consulta) DESC LIMIT 5;");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;
			ps.setDate(i++, Date.valueOf(consultaVo.getDataInicial()));
			ps.setDate(i++, Date.valueOf(consultaVo.getDataFinal()));

			try (ResultSet rs = ps.executeQuery()) {
				ConsultaVo vo = null;
				List<ConsultaVo> consultas = new ArrayList<>();

				while (rs.next()) {
					vo = new ConsultaVo();
					vo.setQtdExame(rs.getString("qtdExame"));
					vo.setNmExame(rs.getString("nmExame"));

					consultas.add(vo);
				}
				return consultas;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
