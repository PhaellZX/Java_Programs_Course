package aula14;

import java.lang.System.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class AuthorsDAO {
 
    public int insert(Authors a){
        int rowCount;
        try (Connection conn = ConexaoMySql.getConexaoMySql()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO authors(firstName, lastName) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            rowCount = ps.executeUpdate();
            return rowCount;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return 0;
    }
    
    public Authors read(int id){
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM authors WHERE authorsID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String nome = rs.getString(2);
                String sobrenome = rs.getString(3);
                Authors a = new Authors(id,sobrenome, nome);
                return a;
            }
            conn.close();
        } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
    
    public int update(Authors a){
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE authors SET firstName=?, lastname=? WHERE authorsID=?");
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setInt(3, a.getAuthorsId());
            
            int rowCount = ps.executeUpdate();
            
            conn.close();
            
            return rowCount;
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public int delete(int id){
            try {
                Connection conn = ConexaoMySql.getConexaoMySql();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM authors WHERE authorsID=?");
                ps.setInt(1, id);
                
                int rowCount = ps.executeUpdate();
                
                conn.close();
                
                return rowCount;
                
            } catch (SQLException ex) {
                 java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
     public ArrayList<Authors> list(){
         ArrayList<Authors> minhaLista = new ArrayList<Authors>();
         try {
             Connection conn = ConexaoMySql.getConexaoMySql();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM authors");
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 int id = rs.getInt(1);
                 String firstnome = rs.getString(2);
                  String lastnome = rs.getString(3);
                 Authors a = new Authors(id,firstnome, lastnome);
                 minhaLista.add(a);
             }
             conn.close();
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return minhaLista;
     }
}
