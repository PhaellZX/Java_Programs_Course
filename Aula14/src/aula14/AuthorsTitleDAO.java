package aula14;

import aula14.AuthorsDAO;
import aula14.ConexaoMySql;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class AuthorsTitleDAO {

    public void associarAutorLivro(int idAutor, int idLivro) {
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO AuthorTitle (atAuthorsID, atISBN) VALUES (?, ?)");
            ps.setInt(1, idAutor);
            ps.setInt(2, idLivro); 
            ps.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void dasassociarAutorLivro(int idAutor, int idLivro){
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM AuthorTitle WHERE atAuthorsID=? AND atISBN=?");
            ps.setInt(1, idAutor);
            ps.setInt(2, idLivro);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
              java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public ArrayList<Authors> buscarAuthorsPorTitle(int idLivro) {
        ArrayList<Authors> autores = new ArrayList<>();
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            PreparedStatement ps = conn.prepareStatement("SELECT authors.*, AuthorTitle.atisbn FROM AuthorTitle " + 
                                                         "JOIN authors ON AuthorTitle.atAuthorID = authors.authorsID " +
                                                        "WHERE AuthorTitle.atISBN = ?");
            ps.setInt(1, idLivro);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Authors a = new Authors(rs.getInt("authorsID"), rs.getString("nome"), rs.getString("outros_campos")); // Substitua "outros_campos" pelos nomes corretos das colunas
                autores.add(a);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autores; // Retorna a lista de autores
    }
   public ArrayList<Titles> buscarTitlePorAuthors(int idAutor) {
        ArrayList<Titles> livros = new ArrayList<>();
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            PreparedStatement ps = conn.prepareStatement("SELECT titles.*, AuthorsTitle.atAuthorsID FROM AuthorTitle " + 
                                                         "JOIN titles ON AuthorTitle.atISBN = Titles.ISBN " +
                                                        "WHERE AuthorTitle.atAuthorsID = ?");
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Titles t = new Titles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                livros.add(t);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros; 
    }
}
