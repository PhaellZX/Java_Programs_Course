
package aula14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

public class TitlesDAO {
     public int insert(Titles t){
        int rowCount;
        try (Connection conn = ConexaoMySql.getConexaoMySql()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO titles(title, EditionNumber, copyright) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getEditionNumber());
            ps.setString(3, t.getCopyright());
            rowCount = ps.executeUpdate();
            return rowCount;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return 0;
    }
    
    public Titles read(int isbn){
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM titles WHERE isbn=?");
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String titles = rs.getString(2);
                String editionNumber = rs.getString(3);
                String copyright = rs.getString(4);
                Titles t = new Titles(isbn,titles,editionNumber,copyright);
                return t;
            }
            conn.close();
        } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
    
    public int update(Titles t){
        try {
            Connection conn = ConexaoMySql.getConexaoMySql();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE titles SET title=?, EditionNumber=? , copyright=? WHERE isbn=?");
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getEditionNumber());
            ps.setString(3, t.getCopyright());
            ps.setInt(4, t.getIsbn());
            
            int rowCount = ps.executeUpdate();
            
            conn.close();
            
            return rowCount;
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public int delete(int isbn){
            try {
                Connection conn = ConexaoMySql.getConexaoMySql();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM titles WHERE isbn=?");
                ps.setInt(1, isbn);
                
                int rowCount = ps.executeUpdate();
                
                conn.close();
                
                return rowCount;
                
            } catch (SQLException ex) {
                 java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
     public ArrayList<Titles> list(){
         ArrayList<Titles> minhaLista = new ArrayList<Titles>();
         try {
             Connection conn = ConexaoMySql.getConexaoMySql();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM titles");
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 int isbn = rs.getInt(1);
                 String title = rs.getString(2);
                 String editiomNumber = rs.getString(3);
                 String copyright = rs.getString(4);
                 Titles t = new Titles(isbn, title, editiomNumber, copyright);
                 minhaLista.add(t);
             }
             conn.close();
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return minhaLista;
     }
}
