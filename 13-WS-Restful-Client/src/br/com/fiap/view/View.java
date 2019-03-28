package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.EmpresaTO;

public class View {
	
	private static EmpresaRepository rep = new EmpresaRepository();

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
			
		case 2:
			pesquisar(scan);
			break;
			
		case 3:
		   cadastrar(scan);
		   break; 
		   
		case 4: 
			atualizar(scan);  
			break;
		
		case 5: 
			remover(scan);
			break;
			
		default: System.out.println("Opção inválida!");
			break;
		}
		
		
		scan.close();
	}


	private static void remover(Scanner scan) {
		
		System.out.println("Digite o código: ");
		int cod = scan.nextInt();
		
		try {
			rep.remover(cod);
			System.out.println("Cadastro de empresa removida com sucesso!");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		
	}


	private static EmpresaTO atualizar(Scanner scan) {
		EmpresaTO e;
		e = new EmpresaTO(); 
		System.out.println("Digite o nome: ");
		e.setNome(scan.next() + scan.nextLine());

		System.out.println("Faturamento: ");
		e.setFaturamento(scan.nextDouble());
   
		System.out.println("Multinacional: ");
		e.setMultinacional(scan.nextBoolean());
		return e;
	}
	
	
	private static EmpresaTO cadastrar(Scanner scan) {
		
		EmpresaTO e = new EmpresaTO(); 
		System.out.println("Digite o nome: ");
		e.setNome(scan.next() + scan.nextLine());
		
	    System.out.println("Faturamento: ");
	    e.setFaturamento(scan.nextDouble());
	    
	    System.out.println("Multinacional: ");
	    e.setMultinacional(scan.nextBoolean());
		
		try {
			rep.cadastrar(e);
			System.out.println("Cadastro realizado com sucesso!");
		} catch (ResponseException e1) {
			e1.printStackTrace();
		}
		return e;
		
	}


	private static void pesquisar(Scanner scan) {
		
		System.out.println("Digite o código: ");
		int cod = scan.nextInt();
		
		try {
			EmpresaTO e = rep.pesquisar(cod);
			System.out.println(e.getNome());
			System.out.println("Faturamento: " + e.getFaturamento());
			System.out.println("Multinacional: " +e.isMultinacional());
			System.out.println("***********************************");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		
	}




	public static void listar() {
		EmpresaRepository rep = new EmpresaRepository();
		try {
			List<EmpresaTO> lista = rep.listar();
			
			for (EmpresaTO e : lista) {
				System.out.println(e.getNome());
				System.out.println("Faturamento: " + e.getFaturamento());
				System.out.println("Multinacional: " +e.isMultinacional());
				System.out.println("***********************************");
			}
			
		} catch (ResponseException e) {
			e.printStackTrace();
		}
	}
	
}
