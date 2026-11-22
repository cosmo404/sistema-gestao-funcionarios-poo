package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

    private static final String URL = "jdbc:sqlite:empresa.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS funcionarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "salario REAL NOT NULL, "
                + "cargo TEXT NOT NULL, "
                + "departamento TEXT, "
                + "numero_caixa INTEGER"
                + ");";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela no banco: " + e.getMessage());
        }
    }
}
