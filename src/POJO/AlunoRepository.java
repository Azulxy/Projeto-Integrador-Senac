package POJO;

import DBConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlunoRepository {
    
    private static final String INSERT_QUERY = "INSERT INTO alunos (codigo_matricula, nome, telefone, serie, nota_matematica, nota_portugues, nota_ciencias, nota_historia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM alunos WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM alunos";
    private static final String UPDATE_QUERY = "UPDATE alunos SET codigo_matricula = ?, nome = ?, telefone = ?, serie = ?, nota_matematica = ?, nota_portugues = ?, nota_ciencias = ?, nota_historia = ? WHERE id = ?";

    public static boolean cadastrarAluno(Aluno aluno) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, aluno.getCodigoMatricula());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getTelefone());
            preparedStatement.setString(4, aluno.getSerie());
            preparedStatement.setFloat(5, aluno.getNotaMatematica());
            preparedStatement.setFloat(6, aluno.getNotaPortugues());
            preparedStatement.setFloat(7, aluno.getNotaCiencias());
            preparedStatement.setFloat(8, aluno.getNotaHistoria());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String codigoMatricula = resultSet.getString("codigo_matricula");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String serie = resultSet.getString("serie");
                float notaMatematica = resultSet.getFloat("nota_matematica");
                float notaPortugues = resultSet.getFloat("nota_portugues");
                float notaCiencias = resultSet.getFloat("nota_ciencias");
                float notaHistoria = resultSet.getFloat("nota_historia");

                Aluno aluno = new Aluno(codigoMatricula, nome, telefone, serie);
                aluno.setId(id);
                aluno.setNotaMatematica(notaMatematica);
                aluno.setNotaPortugues(notaPortugues);
                aluno.setNotaCiencias(notaCiencias);
                aluno.setNotaHistoria(notaHistoria);

                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }

    public static boolean excluirAluno(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean atualizarAluno(Aluno alunoAtualizado) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, alunoAtualizado.getCodigoMatricula());
            preparedStatement.setString(2, alunoAtualizado.getNome());
            preparedStatement.setString(3, alunoAtualizado.getTelefone());
            preparedStatement.setString(4, alunoAtualizado.getSerie());
            preparedStatement.setFloat(5, alunoAtualizado.getNotaMatematica());
            preparedStatement.setFloat(6, alunoAtualizado.getNotaPortugues());
            preparedStatement.setFloat(7, alunoAtualizado.getNotaCiencias());
            preparedStatement.setFloat(8, alunoAtualizado.getNotaHistoria());
            preparedStatement.setInt(9, alunoAtualizado.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public static Aluno buscarAlunoPorCodigoMatricula(String codigoMatricula) {
        Aluno aluno = null;
        String query = "SELECT * FROM alunos WHERE codigo_matricula = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, codigoMatricula);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String serie = resultSet.getString("serie");
                float notaMatematica = resultSet.getFloat("nota_matematica");
                float notaPortugues = resultSet.getFloat("nota_portugues");
                float notaCiencias = resultSet.getFloat("nota_ciencias");
                float notaHistoria = resultSet.getFloat("nota_historia");
                
                aluno = new Aluno(codigoMatricula, nome, telefone, serie);
                aluno.setId(id);
                aluno.setNotaMatematica(notaMatematica);
                aluno.setNotaPortugues(notaPortugues);
                aluno.setNotaCiencias(notaCiencias);
                aluno.setNotaHistoria(notaHistoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aluno;
    }
    
}
