package br.com.PI2.controller;

import DBConnection.DatabaseConnection;
import br.com.PI2.view.CadastroView;
import br.com.PI2.view.LoginView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginController {
    private static final String SELECT_QUERY = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
    private static final String INSERT_QUERY = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
    
    public static boolean verificarCredenciais(String email, String senha) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Retorna true se encontrou um usuário com o email e senha informados
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
