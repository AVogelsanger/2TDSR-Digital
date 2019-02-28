package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.bo.DisciplinaBOStub.CalcularMediaResponse;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		
		//Ler os valores de nac, am e ps
		System.out.println("Nac: ");
		float nac = scan.nextFloat();
		
		System.out.println("AM: ");
		float am = scan.nextFloat();
		
		System.out.println("Ps: ");
		float ps = scan.nextFloat();
		
		
		
		
		//Instanciar o stub para acessar o web service
		try {
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			CalcularMedia valores = new CalcularMedia();
			valores.setAm(am);
			valores.setNac(nac);
			valores.setPs(ps);
			
			//Chamando o Web Service
			CalcularMediaResponse resp = stub.calcularMedia(valores);
			
			//Recuperar o valor retornado pelo web service
			double media = resp.get_return();
			System.out.println("Média: " + media);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		scan.close();

	}

}
