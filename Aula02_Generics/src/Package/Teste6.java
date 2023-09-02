package Package;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// Obs: Crie uma pasta dentro do C: chamada de temp, e depois cria um in.txt com esses dados:
/*Alex Blue,15
Maria Green,22
Bob Brown,21
Alex Blue,30
Bob Brown,15
Maria Green,27
Maria Green,22
Bob Brown,25
Alex Blue,31*/

public class Teste6 {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		
		System.out.println("Insira o caminho completo do arquivo: ");
		String path = sc.nextLine(); // c:\temp\in.txt
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if (votes.containsKey(name)) {
					int votesSofar = votes.get(name);
					votes.put(name, count + votesSofar);
				} else {
					votes.put(name, count);
				}
				line = br.readLine();
			}
			for(String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}