package dao;

import model.Caixa;
import model.Funcionario;
import model.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void cadastrar(Funcionario func) {
        String sql = "INSERT INTO funcionarios (nome, salario, cargo, departamento, numero_caixa) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, func.getNome());
            pstmt.setDouble(2, func.getSalario());

            if (func instanceof Gerente) {
                Gerente g = (Gerente) func;
                pstmt.setString(3, "GERENTE");
                pstmt.setString(4, g.getDepartamento());
                pstmt.setNull(5, Types.INTEGER);
            } else if (func instanceof Caixa) {
                Caixa c = (Caixa) func;
                pstmt.setString(3, "CAIXA");
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setInt(5, c.getNumeroCaixa());
            }

            pstmt.executeUpdate();
            System.out.println("Funcionario salvo no banco de dados com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionario: " + e.getMessage());
        }
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = ConexaoBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double salario = rs.getDouble("salario");
                String cargo = rs.getString("cargo");

                Funcionario f;
                if ("GERENTE".equalsIgnoreCase(cargo)) {
                    String departamento = rs.getString("departamento");
                    f = new Gerente(id, nome, salario, departamento);
                } else {
                    int numeroCaixa = rs.getInt("numero_caixa");
                    f = new Caixa(id, nome, salario, numeroCaixa);
                }
                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionario: " + e.getMessage());
            return false;
        }
    }
}
