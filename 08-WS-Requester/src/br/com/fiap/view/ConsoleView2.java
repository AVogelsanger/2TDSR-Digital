package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularNotaExame;
import br.com.fiap.bo.DisciplinaBOStub.CalcularNotaExameResponse;

public class ConsoleView2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Nota Exame
		System.out.println("Digite a média: ");
		float media = scan.nextFloat();
		
		
		try {
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			CalcularNotaExame valores = new CalcularNotaExame();
			valores.setMedia(media);
			
			
			CalcularNotaExameResponse resp = stub.calcularNotaExame(valores);
			System.out.println("Nota necessária: " + resp.get_return());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		scan.close();
	}
}
