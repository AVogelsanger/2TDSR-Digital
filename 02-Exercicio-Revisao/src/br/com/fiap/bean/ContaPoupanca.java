package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento{

	private float taxa;

	public static final float RENDIMENTO = 0.4f;

	//double valor = 0;
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo*RENDIMENTO;
	}

	@Override
	public double retirar(double valor) throws Exception{
		if (saldo < (valor + taxa)) {
			throw new Exception("Retira n�o permitida.\n N�o h� saldo.");
		}
		return saldo -= valor + taxa;
	}
	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
