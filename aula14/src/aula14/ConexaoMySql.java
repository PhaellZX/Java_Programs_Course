package aula14;

import java.sql.*;

public class ConexaoMySql {
    
    public static java.sql.Connection getConexaoMySql(){
        Connection conn = null;
        
        String serverName = "localhost";
        String mydatabase = "aula12";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "root";
        String password = "";
        
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }    
}
