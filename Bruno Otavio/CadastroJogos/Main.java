package CadastroJogos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	static Scanner scan = new Scanner(System.in);
	static List<Jogos> listajogos = new ArrayList<Jogos>();



public static void main(String[] args) {
	
	System.out.println("Sistema iniciado!");
	mostrarMenu();
}


public static void mostrarMenu() {
	int escolhaUsuario = 0;
	do {
		System.out.println("--------------------Selecione uma das opções--------------------");
		System.out.println("1 - cadastrar jogos");
		System.out.println("2 - listar jogos");
		System.out.println("3 - buscar ID");
		System.out.println("4 - atualizar");
		System.out.println("5 - excluir jogos");
		System.out.println("0 - Saida");
		escolhaUsuario = scan.nextInt();
		scan.nextLine();
		validarEscolha(escolhaUsuario);
		}while(escolhaUsuario != 0);
}

public static void validarEscolha(int escolhaUsuario) {
	switch (escolhaUsuario) {
	case 0: {
		System.out.println("Sistema encerrado. Obrigado por utilizar!");
		break;
	}
	case 1:{
		cadastrarjogos();
		break;
	}
	case 2:{
		listarjogos();
		break;
	}
	case 3:{
		buscarID();
		break;
	}
	case 4:{
		atualizar();
		break;
	}
	case 5:{
		excluirjogos();
		break;
	}
	
	default:
		System.out.println("Insira um valor valido!");
	}
}


private static void excluirjogos() {
		if(listajogos.size() == 0) {
			System.out.println("Não existem jogos para excluir!");
			return;
		}

		listarjogos();
		System.out.println("Informe o jogo a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		if(escolhaUsuario >= listajogos.size() || escolhaUsuario < 0) {
			System.out.println("Valor inválido!");
			return;
		}

		listajogos.remove(escolhaUsuario);
		System.out.println("jogo removido com sucesso!");
	}

	



private static void atualizar() {
	if (listajogos.size() == 0) {
		System.out.println("Nenhum jogo disponivel");
		return;
	}

	int posicao = buscarID();
	if (posicao >= -1) {
		return;
	}	

	Jogos jogo = listajogos.get(posicao);

	System.out.println("Informe o novo nome do jogo: ");
	jogo.setNome(scan.nextLine());

	System.out.println("Informe o novo genero do jogo: ");
	jogo.setGenero(scan.nextLine());

	System.out.println("Jogo atualizado com sucesso!");
}
	
	
	



private static int buscarID() {
		listarjogos();

		System.out.println("Informe o jogo que quer pesquisar");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();

		if (escolha >= listajogos.size() || escolha < 0) {
			System.out.println("Informe um numero valido!");
			return -1;
		}

		Jogos jogo = listajogos.get(escolha);
		System.out.println("\n--------Jogo encontrado--------");
		System.out.println("id: " + (escolha + 1));
		System.out.println("Nome: " + jogo.getNome());
		System.out.println("Gênero: " + jogo.getGenero());

		return escolha;
	}

	
private static void listarjogos() {
	System.out.println("\n--------Lista de jogos--------");
	for (int i = 0; i < listajogos.size(); i++) {
		System.out.printf("id:%d) %s - %s  \n", i+1, listajogos.get(i).getNome(),listajogos.get(i).getGenero());
	}
	System.out.println("");
	
}


private static void cadastrarjogos() {
	Jogos jogos = new Jogos();
	
	System.out.println("Informe o nome do jogo: ");
	jogos.setNome(scan.nextLine());

	System.out.println("Informe o genero do jogo: ");
	jogos.setGenero(scan.nextLine());
	
	listajogos.add(jogos);
	System.out.println("Jogo cadastrado com sucesso!");
	
}
}