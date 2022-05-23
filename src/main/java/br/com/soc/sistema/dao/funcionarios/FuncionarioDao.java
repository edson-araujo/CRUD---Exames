package br.com.soc.sistema.dao.funcionarios;

import br.com.soc.sistema.dao.Dao;



import br.com.soc.sistema.vo.FuncionarioVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioDao extends Dao {

    public List<FuncionarioVo> findAllFuncionarios() {
        StringBuilder query = new StringBuilder(
                "SELECT id_funcionario id, nm_funcionario nome FROM funcionario"
        );
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery()
        ) {
            FuncionarioVo vo = null;
            List<FuncionarioVo> funcionarios = new ArrayList<>();
            while (rs.next()) {
                vo = new FuncionarioVo();
                vo.setIdFuncionario(rs.getString("id"));
                vo.setNome(rs.getString("nome"));

                funcionarios.add(vo);
            }
            return funcionarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    
    public void insertFuncionario(FuncionarioVo funcionarioVo) {
        StringBuilder query = new StringBuilder(
                "INSERT INTO funcionario (nm_funcionario) values (?)"
        );
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())
        ) {
            int i = 1;
            ps.setString(i++, funcionarioVo.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteFuncionario(Integer codigo) {
        StringBuilder query = new StringBuilder(
                "DELETE FROM funcionario WHERE id_funcionario = ?"
        );
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())
        ) {
            int i = 1;
            ps.setInt(i++, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateFuncionario(FuncionarioVo funcionarioVo) {
        StringBuilder query = new StringBuilder(
                "UPDATE funcionario SET (nm_funcionario) = ? WHERE id_funcionario = ?"
        );
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())
        ) {
            int i = 1;
            ps.setString(i++, funcionarioVo.getNome());
            ps.setInt(i++, Integer.parseInt(funcionarioVo.getIdFuncionario()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FuncionarioVo> findAllByNome(String nome) {
        StringBuilder query = new StringBuilder(
                "SELECT id_funcionario id, nm_funcionario nome FROM funcionario "
        )
                .append("WHERE lower(nm_funcionario) like lower(?)");

        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())
        ) {
            int i = 1;

            ps.setString(i, "%" + nome + "%");

            try (ResultSet rs = ps.executeQuery()) {
                FuncionarioVo vo = null;
                List<FuncionarioVo> funcionarios = new ArrayList<>();

                while (rs.next()) {
                    vo = new FuncionarioVo();
                    vo.setIdFuncionario(rs.getString("id"));
                    vo.setNome(rs.getString("nome"));

                    funcionarios.add(vo);
                }
                return funcionarios;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public FuncionarioVo findByCodigo(Integer codigo) {
        StringBuilder query = new StringBuilder(
                "SELECT id_funcionario id, nm_funcionario nome FROM funcionario WHERE id_funcionario = ?"
        );

        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())
        ) {
            int i = 1;

            ps.setInt(i, codigo);

            try (ResultSet rs = ps.executeQuery()) {
                FuncionarioVo vo = null;

                while (rs.next()) {
                    vo = new FuncionarioVo();
                    vo.setIdFuncionario(rs.getString("id"));
                    vo.setNome(rs.getString("nome"));
                }
                return vo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
