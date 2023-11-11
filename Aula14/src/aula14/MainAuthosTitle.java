package aula14;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    AuthorsDAO conAuthor = new AuthorsDAO();
    TitlesDAO conTitles = new TitlesDAO();
    static Scanner teclado = new Scanner(System.in);
    static Main user = new Main();
    
    public static void main(String[] args) {
        int opcao = 1;
        
        while(opcao!=0){
            user.menu();
            
            opcao = teclado.nextInt();
            switch(opcao){
                case 1:
                    user.cadastrarLivros();
                break;
                case 2:
                    user.excluirAutorDoLivro();
                break;
                case 3:
                    user.buscarLivro();
                break;
                case 4:
                    user.buscarAutor();
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
        System.out.println("----------MENU---------");
        System.out.println("1 - Cadastrar Livro\n2 - Excluir Autor do Livro\n3 - Buscar Livro\n4 - Buscar Autor\n0 - Sair");
    }
    public void logout(){
        System.out.println("Saindo...");
    }
    public void error(){
        System.out.println("ERROR! valor invalido!");
    }
    public void cadastrarLivros(){
        System.out.println("\n------->CADASTRAR LIVROS<------");
        System.out.println("Digite o ISBN do Livro: ");
        int ISBN = teclado.nextInt();
        teclado.nextLine(); 
    
        System.out.println("Digite o título do livro: ");
        String titulo = teclado.nextLine();
        System.out.println("Digite a edição do Livro: ");
        String ed = teclado.nextLine();
        System.out.println("Digite os direitos autorais do livro: ");
        String direito = teclado.nextLine();
    
        Titles novoL = new Titles(ISBN, titulo, ed, direito);
        TitlesDAO tdao = new TitlesDAO();
        AuthorsTitleDAO atdao = new AuthorsTitleDAO();
        
        if(tdao.insert(novoL) > 0){
            System.out.println("Quantos autores possui o livro? ");
            String temp = teclado.nextLine();
            int qtdAut = Integer.parseInt(temp);
            for(int i = 1; i <= qtdAut; i++){
                System.out.println("Qual codigo do autor? ");
                temp = teclado.nextLine();
                int idAu = Integer.parseInt(temp);
                atdao.associarAutorLivro(idAu, ISBN);
            }
            System.out.println("\nNovo livro cadastrado com sucesso!");
            
        }else{
            System.out.println("\nNão foi possível cadastrar o livro");
        }
    }
   public void excluirAutorDoLivro() {
        System.out.println("\n--------->EXCLUIR AUTOR DO LIVRO<--------");
        System.out.println("Digite o ISBN do livro que deseja remover: ");

        int cod = 0;
        try {
            cod = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
           teclado.nextLine(); 
           return;
        }

        AuthorsTitleDAO atDao = new AuthorsTitleDAO();

        ArrayList<Authors> listaAutores = atDao.buscarAuthorsPorTitle(cod);

        System.out.println("\n-------->AUTORES ENCONTRADOS<--------");
        for (int i = 0; i < listaAutores.size(); i++) {
        Authors a = listaAutores.get(i);
        System.out.println("Codigo do autor: " + a.getAuthorsId());
        System.out.println("Nome do autor: " + a.getFirstName());
        System.out.println("Sobrenome do autor: " + a.getLastName());
    }

        System.out.println("\nQuantos autores desejas excluir? ");
        int qtdAu = 0;

        try {
            qtdAu = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
        teclado.nextLine(); 
        return;
        }

        if (qtdAu > 0) {
           for (int i = 1; i <= qtdAu; i++) {
               System.out.println("Digite o código do autor a ser excluído: ");
               int codAu = 0;

               try {
                   codAu = teclado.nextInt();
               } catch (InputMismatchException e) {
                   System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
                   teclado.nextLine(); 
                   return;
               }

               atDao.dasassociarAutorLivro(codAu, cod);
           }

           System.out.println("\nAutores excluídos com sucesso!");
       }
     }
   public void buscarLivro(){
        System.out.println("Digite o ISBN do livro que deseja buscar: ");
        int cod = 0;

        try {
            cod = teclado.nextInt();
            teclado.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
            teclado.nextLine(); 
            return;
        }

        TitlesDAO tDao = new TitlesDAO();

        Titles t = tDao.read(cod);

        if (t != null) {
            System.out.println("\n--------->LIVRO ENCONTRADO<---------");
            System.out.println("ISBN do Livro: " + t.getIsbn());
            System.out.println("Titulo do livro: " + t.getTitle());
            System.out.println("Edicao do livro: " + t.getEditionNumber());
            System.out.println("Direitos autorais do livro: " + t.getCopyright());

            System.out.println("Desejas ver os autores deste livro? ");
            int op = 0;

            try {
                op = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
                teclado.nextLine(); 
                return;
            }

            if (op == 1) {
                AuthorsTitleDAO atDao = new AuthorsTitleDAO();

                ArrayList<Authors> listaAutores = atDao.buscarAuthorsPorTitle(cod);
                for (int i = 0; i < listaAutores.size(); i++) {
                    Authors a = listaAutores.get(i);

                    System.out.println("Codigo do autor: " + a.getAuthorsId());
                    System.out.println("Nome do autor: " + a.getFirstName());
                    System.out.println("Sobrenome do autor: " + a.getLastName());
                    System.out.println("____________________________");
                }
            } else {
                System.out.println("\nLivro não encontrado!!");
            }
          }
       }
  public void buscarAutor() {
        System.out.println("\n---------->Buscar Autor<-----------");

        try {
            System.out.println("Digite o código do autor que deseja buscar: ");
            int cod;
            while (true) {
                String input = teclado.nextLine();
                if (input.matches("^\\d+$")) {
                    cod = Integer.parseInt(input);
                    if (cod > 0) {
                        break;
                    }
                }
                System.out.println("Por favor, insira um código de autor válido (número inteiro positivo).");
            }

            AuthorsDAO auDao = new AuthorsDAO();
            Authors autor = auDao.read(cod);

            if (autor != null) {
                System.out.println("\n--------->AUTOR ENCONTRADO<---------");
                System.out.println("Codigo do autor: " + autor.getAuthorsId());
                System.out.println("Nome do autor: " + autor.getFirstName());
                System.out.println("Sobrenome do autor: " + autor.getLastName());
                System.out.println("________________________________________");

                System.out.println("Deseja ver os livros que ele escreveu? (1 - Sim, 0 - Não)");
                int op = Integer.parseInt(teclado.nextLine());

                if (op == 1) {
                    AuthorsTitleDAO atDao = new AuthorsTitleDAO();
                    ArrayList<Titles> listaLivros = atDao.buscarTitlePorAuthors(cod);

                    if (!listaLivros.isEmpty()) {
                        System.out.println("\n--------->LIVROS DO AUTOR<---------");
                        for (Titles t : listaLivros) {
                            System.out.println("ISBN: " + t.getIsbn());
                            System.out.println("Nome do livro: " + t.getTitle());
                            System.out.println("Edicao do livro: " + t.getEditionNumber());
                            System.out.println("Direitos autorais do livro: " + t.getCopyright());
                            System.out.println("_________________________________");
                        }
                    } else {
                        System.out.println("\nO autor não escreveu nenhum livro.");
                    }
                }
            } else {
                System.out.println("\nAutor não encontrado!!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um código de autor válido.");
        }
      }
    }
   
