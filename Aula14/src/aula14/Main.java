package aula14;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    AuthorsDAO conAuthor = new AuthorsDAO();
    TitlesDAO conTitles = new TitlesDAO();
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        Main user = new Main();
        int opcao = 1;
        
        while(opcao!=0){
            user.menu();
            
            opcao = in.nextInt();
            
            switch(opcao){
                case 1:
                  user.listarAutores();
                break;
                case 2:
                  user.listarLivros();
                break;
                case 3:
                  user.cadastrarAutor();
                break;
                case 4:
                  user.cadastrarLivro();
                break;
                case 5:
                  user.alterarAutor();
                break;
                case 6:
                  user.alterarLivro();
                break;
                case 7:
                  user.apagarAutor();
                break;
                case 8:
                  user.apagarLivro();
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
    public void menu(){
         System.out.println("--------JAVA BOOK--------");
         System.out.println("O que voce quer fazer?\n1 - Mostrar Lista de Autores\n2 - Mostrar lista de livros\n3 - Cadastrar Autor\n4 - Cadastrar Livro\n5 - Alterar cadastrar autor\n6 - Alterar cadastro livro\n7 - Excluir Autor\n8 - Excluir Livro\n0 - Sair");
    }
    public void error(){
        System.out.println("Error! valor invalido!");
    }
    public void logout(){
        System.out.println("Fazendo o logout... FIM");
    }
    public void listarAutores(){
        ArrayList<Authors> listar = conAuthor.list(); 
        System.out.println("------------------------------");
        for(Authors autor : listar){
            System.out.println("ID:" + autor.getAuthorsId());
            System.out.println("First Name:" + autor.getFirstName());
            System.out.println("Last Name:" + autor.getLastName());
            System.out.println("-------------------------------");
        }
    }
    public void listarLivros(){
        ArrayList<Titles> listar = conTitles.list(); 
        System.out.println("------------------------------");
        for(Titles title : listar){
            System.out.println("ISBN:" + title.getIsbn());
            System.out.println("Titulo:" + title.getTitle());
            System.out.println("N° Edicao:" + title.getEditionNumber());
            System.out.println("Copyright: " + title.getCopyright());
            System.out.println("-------------------------------");
        }
    }
    public void cadastrarAutor(){
        System.out.println("Digite o primeiro nome do autor: ");
        String firstName = in.next();
        System.out.println("Digite o sobrenome do autor: ");
        String lastName = in.next();
        
        Authors a = new Authors(firstName, lastName);
        conAuthor.insert(a);
        System.out.println("Autor Cadastrado com sucesso!!");
    }
    public void cadastrarLivro(){
        System.out.println("Digite o titulo do livro: ");
        String title = in.next();
        System.out.println("Digite o n° da edicao: ");
        String editiomNumber = in.next();
        System.out.println("Digite o copyright: ");
        String copyright = in.next();
        
        Titles t = new Titles(title, editiomNumber, copyright);
        conTitles.insert(t);
        System.out.println("Livro Cadastrado com sucesso!!");
    }
    public void alterarAutor(){
        
        System.out.println("Digite o ID do autor: ");
        int id = in.nextInt();
        int opcao = 1;
        
        Authors search = conAuthor.read(id);
        
        while(opcao!=0){
            System.out.println("Escolha o que deseja alterar: \n1 - Nome\n2 - Sobrenome\n0 - Voltar ao menu");
            opcao = in.nextInt();
           
            switch(opcao){
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = in.next();
                    search.setFirstName(nome);
                    System.out.println("Nome Alterado!! codigo: " + id);
                break;
                case 2:
                    System.out.println("Digite o sobrenome: ");
                    String sobrenome = in.next();
                    search.setLastName(sobrenome);
                    System.out.println("Sobrenome Alterado!! codigo: " + id);
                break;
                case 0:
                    System.out.println("Voltando ao menu");
                break;
                default:
                    System.out.println("Valor invalido");
                break;
            }
        }
        conAuthor.update(search);
    }
    public void alterarLivro(){
       
        System.out.println("Digite o ISBN do livro: ");
        int isbn = in.nextInt();
        int opcao = 1;
        
        Titles search = conTitles.read(isbn);
        
        while(opcao!=0){
            System.out.println("Escolha o que deseja alterar: \n1 - Titulo\n2 - n° Edicao\n3 - Copyright\n0 - Voltar ao menu");
            opcao = in.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Digite o titulo: ");
                    String titulo = in.next();
                    search.setTitle(titulo);
                    System.out.println("Titulo Alterado!! codigo: " + isbn);
                break;
                case 2:
                    System.out.println("Digite o n° da edicao: ");
                    String editionNumber = in.next();
                    search.setEditionNumber(editionNumber);
                    System.out.println("Numero da edicao Alterado!! codigo: " + isbn);
                break;
                case 3:
                    System.out.println("Digite o copyright: ");
                    String copyright = in.next();
                    search.setCopyright(copyright);
                    System.out.println("Copyright Alterado!! codigo: " + isbn);
                break;
                case 0:
                    System.out.println("Voltando ao menu");
                break;
                default:
                    System.out.println("Valor invalido");
                break;
            }
        }
       conTitles.update(search);
    }
    public void apagarAutor(){
        System.out.println("Digite o id do autor: ");
        int id = in.nextInt();
        conAuthor.delete(id);
        System.out.println("Autor Apagado!");
    }
    public void apagarLivro(){
        System.out.println("Digite o isbn do livro: ");
        int isbn = in.nextInt();
        conTitles.delete(isbn);
        System.out.println("Livro Apagado!");
    }
}