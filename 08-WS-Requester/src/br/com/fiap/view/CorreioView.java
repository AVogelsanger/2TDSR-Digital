package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreioView {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Calcular o prazo de entrega
		System.out.println("CEP de Origem: ");
		String cepOrigin = scan.next();

		System.out.println("CEP de Destino: ");
		String cepDestino = scan.next();
		
		
		try {
			//Obj pra chamar o web service
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			//Valores que serão enviados para o web service
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010");
			valores.setSCepOrigem(cepOrigin);
			valores.setSCepDestino(cepDestino);
			
			//chamando o web service
			CalcPrazoResponse resp = stub.calcPrazo(valores);
			
			System.out.println("Prazo: " + 
								resp.getCalcPrazoResult().getServicos()
								.getCServico()[0].getPrazoEntrega());
			
			System.out.println("Data Máxima: " + 
								resp.getCalcPrazoResult().getServicos()
								.getCServico()[0].getDataMaxEntrega());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//Ler dois ceps
		
		scan.close();
	}

}
