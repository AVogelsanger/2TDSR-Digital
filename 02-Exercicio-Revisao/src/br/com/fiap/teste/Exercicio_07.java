package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio_07 {

	public static void main(String[] args) {
		
		List<ContaCorrente> lista = new ArrayList<>();
		
		lista.add(new ContaCorrente(1, 2,
				new GregorianCalendar(2010, Calendar.DECEMBER, 25),
				5000, TipoConta.Especial));
		
		lista.add(new ContaCorrente(1, 3,
				new GregorianCalendar(2010, Calendar.DECEMBER, 25),
				5000, TipoConta.Especial));
		
		lista.add(new ContaCorrente(1, 4,
				new GregorianCalendar(2010, Calendar.DECEMBER, 25),
				5000, TipoConta.Especial));
		
		
		for (ContaCorrente cc : lista) {
			System.out.println(cc);
		}

	}

}
