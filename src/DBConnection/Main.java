/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author jvazu
 */
public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM usuarios";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Senha: " + senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
