package br.com.fiap.revisao.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColecaoTeste {
	public static void main(String[] args) {
		
		//Lista - o list é uma interface e não pode ser estanciada
		List<String> lista = new ArrayList<String>();
		// add dados na lista
		lista.add("Olá Mundo!");
		lista.add("Hello world!");
		lista.add("Hallo Welt!");
		
		// recuperar uma posição especifica
		System.out.println(lista.get(2));
		System.out.println(lista);
		
		
		//percorrer a lista (for each)
		for (String item : lista) {
			System.out.println(item);
		}
		
		
		System.out.println("");
		System.out.println("SET");
		Set<String> set = new HashSet<String>();
		//add valores
		set.add("Lasanha");
		set.add("Lasanha");
		set.add("Pizza");

		System.out.println(set);
		
		for (String item : set) {
			System.out.println(item);
		}
		
		System.out.println("");
		System.out.println("MAP");
		
		//MAP<Chave, Valor>
		Map<String, String> mapa = new HashMap<>();
		mapa.put("Brasil", "Brasilia");
		mapa.put("Argentina", "Bueno Aires");
		mapa.put("Itália", "Roma");
		
		System.out.println(mapa.get("Itália"));
	}
}
