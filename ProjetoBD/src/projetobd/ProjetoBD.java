package projetobd;

import java.sql.*;
import java.util.Scanner;

public class ProjetoBD { 
    public static void main(String[] args) {
        ProjetoBD projeto = new ProjetoBD();
        Scanner teclado = new Scanner(System.in);
        
        int opcao = 1;
       
        while(opcao != 0){
            projeto.menu();
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    projeto.mostrarAuthors();
                break;
                case 2:
                    projeto.mostrarLivro();
                break;
                case 3:
                    projeto.inserirAuthors();
                break;
                case 4:
                    projeto.inserirLivro();
                break;
                 case 5:
                    projeto.authorsUpdate();
                break;
                case 6:
                    projeto.livroUpdate();
                break;
                case 7:
                    projeto.authorDelete();
                break;
                case 8:
                    projeto.livroDelete();
                break;
                case 0:
                    System.out.println("Logout...");
                break;
                default:
                    System.out.println("Valor Inválido!");
            }
        }
    }  
    public void inserirAuthors(){
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        Scanner teclado = new Scanner(System.in);
        String nome, sobreNome;        
        
        System.out.println("Digite o nome do autor: ");
        nome = teclado.next();
        System.out.println("Digite o sobrenome do autor: ");
        sobreNome = teclado.next();
        
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
    
    public void authorsUpdate(){
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        Scanner teclado = new Scanner(System.in);
         
        System.out.println("Digite o nome: ");
        String nome = teclado.next(); 
        System.out.println("Digite o código: ");
        int codigo = teclado.nextInt(); 
         
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM authors");
        
        System.out.println("########## VAMOS ALTERAR UM AUTOR ############");
       
        
        ps = conn.prepareStatement("UPDATE authors SET firstName=? WHERE authorsID=?");
        ps.setString(1, nome);
        ps.setInt(2, codigo);
        
        int retorno = ps.executeUpdate();
        
        if(retorno > 0){
            System.out.println("\nNovo registro alterado: " + codigo +" - " + nome);
        }else{
            System.out.println("Não foi possível alterar o registro!");
        }
         }catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    
    
    public void authorDelete(){
            Connection conn = null;
            Statement stat = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("\nDigite o codigo que desejas excluir: ");
            int codigo = teclado.nextInt();
       
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM authors");
            
             System.out.println("\n######### VAMOS EXCLUIR UM AUTOR ##########\n");
             while(rs.next()){
                 System.out.println("Codigo do author: " + rs.getInt("authorsID"));
                 System.out.println("Nome do Autor: " + rs.getString(2));
                 System.out.println("Sobrenome do Autor: " + rs.getString("lastName"));
                 System.out.println("---------------------------------");
             }
             
            ps = conn.prepareStatement("DELETE FROM authors WHERE authorsID=?");
            ps.setInt(1, codigo);
            int retorno = ps.executeUpdate();
            
         }catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void mostrarAuthors(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
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
    public void inserirLivro(){
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        Scanner teclado = new Scanner(System.in);
        String titulo, numEdicao, Copyright;
        
        System.out.println("Digite o titulo do livro: ");
        titulo = teclado.next();
        System.out.println("Digite o número da edição: ");
        numEdicao = teclado.next();
        System.out.println("Digite o Copyright: ");
        Copyright = teclado.next();
        
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
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
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
    
    public void livroUpdate(){
        
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        Scanner teclado = new Scanner(System.in);
         
        System.out.println("Digite o titulo: ");
        String titulo = teclado.next(); 
        System.out.println("Digite o codigo(ISBN): ");
        int codigo = teclado.nextInt(); 
         
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM titles");
        
        System.out.println("########## VAMOS ALTERAR O LIVRO ############");
       
        
        ps = conn.prepareStatement("UPDATE titles SET title=? WHERE ISBN=?");
        ps.setString(1, titulo);
        ps.setInt(2, codigo);
        
        int retorno = ps.executeUpdate();
        
        if(retorno > 0){
            System.out.println("\nNovo registro alterado do livro: " + codigo +" - " + titulo);
        }else{
            System.out.println("Não foi possível alterar o registro!");
        }
         }catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    
    public void livroDelete(){
            Connection conn = null;
            Statement stat = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("\nDigite o codigo(ISBN) que desejas excluir: ");
            int codigo = teclado.nextInt();
       
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM titles");
            
             System.out.println("\n######### VAMOS EXCLUIR UM LIVRO ##########\n");
             while(rs.next()){
                 System.out.println("ISBN: " + rs.getInt("ISBN"));
                 System.out.println("Titulo do Livro: " + rs.getString(2));
                 System.out.println("Numero da edição: " + rs.getString(3));
                  System.out.println("Copyright: " + rs.getString(4));
                 System.out.println("---------------------------------");
             }
             
            ps = conn.prepareStatement("DELETE FROM titles WHERE ISBN=?");
            ps.setInt(1, codigo);
            int retorno = ps.executeUpdate();
            
         }catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    
    public void menu(){
        System.out.println("-------------> Escolha uma opcao <-------------\n");
        System.out.println("1 - Mostrar lista de autores");
        System.out.println("2 - Mostrar lista de livros");
        System.out.println("3 - Cadastrar autor");
        System.out.println("4 - Cadastrar livro");
        System.out.println("5 - Alterar Cadastro autor");
        System.out.println("6 - Alterar Cadastro livro");
        System.out.println("7 - Excluir autor");
        System.out.println("8 - Excluir livro");
        System.out.println("0 - Sair");
    }
}


