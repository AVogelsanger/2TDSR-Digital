package br.com.fiap.bo;

import java.rmi.RemoteException;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;

public class TesteCorreio {

	public static void main(String[] args) throws RemoteException {
		
		CalcPrecoPrazoWSStub obj = new CalcPrecoPrazoWSStub();
		CalcPrazo cp = new CalcPrazo();
		cp.setSCepOrigem("05711000");
		cp.setSCepDestino("04125050");
		cp.setNCdServico("04782");
		
		
		System.out.println(obj.calcPrazo(cp).getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
		
		
	}
	
	
	
}
