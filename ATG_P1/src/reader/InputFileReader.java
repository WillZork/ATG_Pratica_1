package reader;
import java.io.*;
import java.util.Scanner;

public class InputFileReader<T> {
	
	public static Integer[] readGraph(String filePath) throws Exception{
		try {
			File file = new File(filePath);
			Scanner scan = new Scanner(file);
			int count = 0;
			
			while (scan.hasNextFloat()) {
				count++;
				scan.nextFloat();
			}
			Integer[] result = new Integer[count];
			scan.close();
			scan = new Scanner(file);
			
			for (int i = 0; i < result.length; i++) {
				result[i] = scan.nextInt();
			}
			
			return result;
			
		} catch (Exception e) {
			throw new Exception("Erro na leitura do grafo.");
		}
	}
	
}		


