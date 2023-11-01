package aula14;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aula14 {
    public static void main(String[] args) {
        Authors a1 = new Authors("Carlos", "Marques");
        Authors a2 = new Authors("Alberto", "Pereira");
        
        // INSERT
        AuthorsDAO conexao = new AuthorsDAO();
        
        //conexao.insert(a1);
        //conexao.insert(a2);
        
       // READ
       //Authors search = conexao.read(13);
       //System.out.println(search.getAuthorsId() + "\n" + search.getFirstName() + "\n" +search.getLastName());
       
        //UPDATE
        //Authors search = conexao.read(21);
        //search.setFirstName("Pablo");
        //search.setLastName("Marques");
        //conexao.update(search);
        
        //DELETE
        //conexao.delete(15);
        
        //LISTAR
        ArrayList<Authors> listar = conexao.list(); 
        System.out.println("------------------------------");
        for(Authors autor : listar){
            System.out.println("ID:" + autor.getAuthorsId());
            System.out.println("First Name:" + autor.getFirstName());
            System.out.println("Last Name:" + autor.getLastName());
            System.out.println("-------------------------------");
        }
    }
}
