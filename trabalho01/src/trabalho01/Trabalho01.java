package trabalho01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Trabalho01 {
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        Trabalho01 user = new Trabalho01();
        int opcao = 1;
        
        while(opcao != 0){
            user.menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
                case 1:
                    user.mostrarPessoas();
                break;
                case 2:
                    user.consultarPessoa();
                break;
                case 3:
                    user.CadastrarPessoa();
                break;
                case 4:
                    user.alterarPessoa();
                break;
                case 5:
                    user.excluirPessoa();
                break;
                case 0:
                    user.logout();
                break;
                default:
                    user.error();
                break;
            }
        }
    }
    
    public void CadastrarPessoa(){
        System.out.println("Digite o nome: ");
        String nome = entrada.next();
        System.out.println("Digite a idade: ");
        int idade = entrada.nextInt();
        
          try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM pessoas");
            
            System.out.println("------------------------------------------");
            System.out.println("");
            
            int rowCount = stat.executeUpdate("INSERT INTO pessoas(nome, idade) VALUES('"+ nome +"','"+ idade +"')",Statement.RETURN_GENERATED_KEYS);
            
            if(rowCount>0){
                rs = stat.getGeneratedKeys();
                while(rs.next()){
                    System.out.println("Pessoa registrada!! código: " + rs.getInt(1)); 
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void mostrarPessoas(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM pessoas");
            
            System.out.println("-----------PESSOAS CADASTRADAS----------");
            
            while(rs.next()){
                System.out.println("----------------------------------------");
                System.out.println("ID: "+rs.getInt(1)); 
                System.out.println("nome: "+rs.getString(2));
                System.out.println("Idade: "+rs.getInt(3)); 
            }
            System.out.println("------------------------------------------");
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void consultarPessoa(){
          try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM pessoas");
            
            System.out.println("Digite o ID: ");
            int cod = entrada.nextInt();
            
            while(rs.next()){
                if(cod == rs.getInt(1)){
                System.out.println("---------------PESSOA ENCONTRADA!----------------");
                System.out.println("ID: "+rs.getInt(1)); 
                System.out.println("nome: "+rs.getString(2));
                System.out.println("Idade: "+rs.getInt(3)); 
                System.out.println("-------------------------------------------------");
                } else {
                    System.out.println("Nao foi possivel achar a pessoa :|");
                }
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void alterarPessoa(){
        
        System.out.println("Digite o ID: ");
        int cod = entrada.nextInt();
        
        System.out.println("O que deseja alterar? \n 1 - nome \n 2 - idade \n 0 - nada");
        int opcao = entrada.nextInt();
        
        switch(opcao){
            case 1:
                System.out.println("Digite o nome para alterar: ");
                String nome = entrada.next();
                  try {
                     conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?"+"user=root");
                     stat = conn.createStatement();
                     rs = stat.executeQuery("SELECT * FROM pessoas");
        
                     ps = conn.prepareStatement("UPDATE pessoas SET nome=? WHERE id=?");
                     ps.setString(1, nome);
                     ps.setInt(2, cod);
        
                     int retorno = ps.executeUpdate();
        
                     if(retorno > 0){
                        System.out.println("\nNovo registro alterado: " + cod +" - " + nome);
                     }else{
                        System.out.println("Não foi possível alterar o registro!");
                    }
                    }catch (Exception e) {
                        System.out.println("Erro: Não conseguiu conectar no BD");
                    }
            break;
            case 2:
                System.out.println("Digite a idade para alterar: ");
                int idade = entrada.nextInt();
                 try {
                     conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?"+"user=root");
                     stat = conn.createStatement();
                     rs = stat.executeQuery("SELECT * FROM pessoas");
        
                     ps = conn.prepareStatement("UPDATE pessoas SET idade=? WHERE id=?");
                     ps.setInt(1, idade);
                     ps.setInt(2, cod);
        
                     int retorno = ps.executeUpdate();
        
                     if(retorno > 0){
                        System.out.println("\nNovo registro alterado: " + cod +" - " + idade + " anos");
                     }else{
                        System.out.println("Não foi possível alterar o registro!");
                    }
                    }catch (Exception e) {
                        System.out.println("Erro: Não conseguiu conectar no BD");
                    }
            break;
            case 0:
                System.out.println("Voltando para o Menu...");
            break;
            default:
                System.out.println("Valor errado!");        
        }
    }
    public void excluirPessoa(){
         
        System.out.println("\nDigite o codigo da Pessoa que desejas excluir: ");
         int cod = entrada.nextInt();
       
         try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?"+"user=root");
            stat = conn.createStatement();
            rs = stat.executeQuery("SELECT * FROM pessoas");
            
             while(rs.next()){
                 if(cod == rs.getInt(1)){
                 System.out.println("----------PESSOA EXCLUIDA!--------");
                 System.out.println("ID: " + rs.getInt(1));
                 System.out.println("Nome: " + rs.getString(2));
                 System.out.println("Idade: " + rs.getString(3));
                 System.out.println("-----------------------------------");   
                 }
             }
             
            ps = conn.prepareStatement("DELETE FROM pessoas WHERE id=?");
            ps.setInt(1, cod);
            int retorno = ps.executeUpdate();
            
         }catch (Exception e) {
            System.out.println("Erro: Não conseguiu conectar no BD");
        }
    }
    public void menu(){
        System.out.println("----------MENU----------");
        System.out.println("1 - Mostrar Pessoas");
        System.out.println("2 - Consultar Pessoa");
        System.out.println("3 - Cadastrar Pessoa");
        System.out.println("4 - Alterar dados da Pessoa");
        System.out.println("5 - Excluir Pessoa");
        System.out.println("0 - Sair");
    }
    public void logout(){
        System.out.println("Saindo...");
    }
    public void error(){
        System.out.println("Valor Invalido!");
    }
}
