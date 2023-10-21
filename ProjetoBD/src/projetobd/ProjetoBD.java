package projetobd;

import java.sql.*;

public class ProjetoBD {
    
     Connection conn = null;
     Statement stat = null;
     ResultSet rs = null;
    
    public static void main(String[] args) {
        ProjetoBD projeto = new ProjetoBD();
        
        // Inserir Autores
        projeto.inserirAuthors("Raphael","Tavares");
        projeto.inserirAuthors("Mateus","Barth");
        projeto.inserirAuthors("Arhtur","Cristovão");
        projeto.inserirAuthors("Bruno","Fernandes");
        
        // Mostrar Autores
        projeto.mostrarAuthors();
        
        // Inserir Livros
        for(int i = 0; i <= 9; i++){
            projeto.inserirLivro("Livro" + i, "Edicao " + i, "Marca Famosa " + i);
        }
        
        // Mostrar Livro
        projeto.mostrarLivro();
    }  
    
    public void inserirAuthors(String nome, String sobreNome){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM authors");
            
            System.out.println("------------------------------------------");
            System.out.println("");
            
            int rowCount = stat.executeUpdate("INSERT INTO authors(firstName, lastName) VALUES('"+ nome +"','"+ sobreNome +"')",Statement.RETURN_GENERATED_KEYS);
            
            if(rowCount>0){
                rs = stat.getGeneratedKeys();
                while(rs.next()){
                    System.out.println("Novo registro realizado no código: " + rs.getInt(1)); // retorna o dado da primeira coluna
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void mostrarAuthors(){
       
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM authors");
            
            while(rs.next()){
                System.out.println("----------------------------------------");
                System.out.println("Codigo do autor: "+rs.getInt(1)); // authorsID
                System.out.println("Nome do autor: "+rs.getString(2)); // firstName
                System.out.println("Sobrenome do autor: "+rs.getString(3)); // lastName
            }
            System.out.println("------------------------------------------");
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void inserirLivro(String titulo, String numEdicao, String Copyright){

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM titles");
            
            System.out.println("------------------------------------------");
            System.out.println("");
            
            int rowCount = stat.executeUpdate("INSERT INTO titles(title, EditionNumber, copyright) VALUES('"+ titulo +"','"+ numEdicao +"','"+ Copyright +"')",Statement.RETURN_GENERATED_KEYS);
            
            if(rowCount>0){
                rs = stat.getGeneratedKeys();
                while(rs.next()){
                    System.out.println("Novo registro realizado no código: " + rs.getInt(1)); // retorna o dado da primeira coluna
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void mostrarLivro(){
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM titles");
            
            while(rs.next()){
                System.out.println("----------------------------------------");
                System.out.println("ISBN: "+rs.getInt(1)); // ISBN
                System.out.println("Titulo do Livro: "+rs.getString(2)); // title
                System.out.println("Edição: "+rs.getString(3)); // EditionNumber
                System.out.println("Copyright: "+rs.getString(4)); // Copyright
            }
            System.out.println("------------------------------------------");
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
}


