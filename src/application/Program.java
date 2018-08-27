package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);	
		
		System.out.println("Recuperando o arquivo sourcerFile na pasta no projeto...");
		String pathSourceFile = System.getProperty("user.dir") + "\\sourceFile.csv";
		
		List<Product> products = new ArrayList<>();
		File sourceFile = new File(pathSourceFile);

		
		try (BufferedReader br = new BufferedReader(new FileReader(pathSourceFile))){
			System.out.println("Lendo o arquivo...");
			String line = br.readLine();
			while(line != null) {
				String inf[] = line.split(",");
				products.add(new Product(inf[0], Float.parseFloat(inf[1]), Integer.parseInt(inf[2])));
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Criando a pasta out no diretorio do projeto...");
		new File(sourceFile.getParent() + "\\out").mkdir();
		
		try (BufferedWriter output = new BufferedWriter(new FileWriter(sourceFile.getParent() + "\\out\\summary.csv"))) {
			System.out.println("Salvando dados em \\out\\summary.csv...");
			for(Product pdt: products) {
				output.write(pdt.toStringFinal());
				output.newLine();
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
