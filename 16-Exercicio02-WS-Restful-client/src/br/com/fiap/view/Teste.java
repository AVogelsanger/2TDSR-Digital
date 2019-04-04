package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.service.VendaService;
import br.com.fiap.to.VendaTO;

public class Teste {
	
	private static VendaService serv = new VendaService();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Escolha uma opção:");

		System.out.println("0 - sair");
		System.out.println("1 - listar");
		System.out.println("2 - pesquisar");
		System.out.println("3 - Cadastrar");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Remover");
		int opcao = scan.nextInt();

		switch (opcao) {
		case 1: listar();
			break;
		case 2: pesquisar(scan);
			break;
		case 3: cadastrar();
			break;
		case 4: atualizar();
			break;
		case 5: remover();
			break;
		default: System.out.println("opção inválida!");
			break;
		}






		scan.close();
	}
	

	private static void remover() {
		// TODO Auto-generated method stub
		
	}


	private static void atualizar() {
		// TODO Auto-generated method stub
		
	}


	private static void cadastrar() {
		// TODO Auto-generated method stub
		
	}


	private static void pesquisar(Scanner scan) {

		System.out.println("Digite o código: ");
		int c = scan.nextInt();
		
		VendaTO v = serv.pesquisar(c);
		System.out.println("Descrição: " + v.getDescricao());
		System.out.println("Valor: " + v.getValor());
		System.out.println("Data: " + v.getData());
		
	}


	private static void listar() {
		//VendaService serv = new VendaService();
		
		List<VendaTO> lista = serv.listar();
		for (VendaTO v : lista) {
			System.out.println("Descrição: " + v.getDescricao());
			System.out.println("Valor: " + v.getValor());
			System.out.println("Data: " + v.getData());
		}
		
	}

}
