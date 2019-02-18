package br.com.fiap.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ContaCorrente extends Conta{

	private TipoConta tipoConta;
	
	@Override
	public double retirar(double valor) throws Exception {
		if (getTipoConta() == TipoConta.Comum && saldo < 0) {
			throw new Exception("Retira não permitida.\n saldo insuficiente.");
		}
		return saldo -= valor;
	}
	
		
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipoConta) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipoConta = tipoConta;
	}
	
	public ContaCorrente() {
		super();
	}	
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Agência: " + getAgencia() + "\n" +
				"Número: " + getNumero() + "\n" +
				"Tipo: " + getTipoConta() + "\n" +
				"Saldo: " + getSaldo() + "\n" +
				"Data de abertura: " + sdf.format(getDataAbertura().getTime()) + "\n";
	}

}
