package cadastrarAlunos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<alunos> listaAlunos = new ArrayList<>();
	static int proximoId = 1;

	public static void main(String[] args) {
		int opcao;
		do {
			System.out.println("===Menu===");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - listar alunos ");
			System.out.println("3 - atualizar cadastros");
			System.out.println("4 - remover cadastro");
			System.out.println("5 - Buscar por Id");
			System.out.println("0 - para sair");
			System.out.println("escolha uma opcao");
			opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {
			case 1: {
				cadastrar();
				break;
			}
			case 2: {
				listar();
				break;
			}
			case 3: {
				atualizar();
				break;
			}
			case 4: {
				removerCadastro();
				break;
			}
			case 5: {
				buscarId();
				break;
			}
			case 0: {
				System.out.println("saindo");
				break;
			}
			default: {
				System.out.println("insira um valor valido");
				break;
			}
			}

		} while (opcao != 0);
	}

	private static void cadastrar() {
		System.out.println("nome do aluno");
		String nome = scan.nextLine();
		System.out.println("curso do aluno");
		String curso = scan.nextLine();
		System.out.println("Nota do aluno");
		double nota = scan.nextDouble();
		scan.nextLine();
		alunos aluno = new alunos(proximoId, nota, nome, curso);
		proximoId += 1;
		listaAlunos.add(aluno);
		System.out.println("aluno cadastrado com Id:" + aluno.getId());
	}

	private static void listar() {
		if (listaAlunos.size() <= 0) {
			System.out.println("nao tem aluno cadastrados no momento");
			return;
		}
		for (int i = 0; i < listaAlunos.size(); i++) {
			alunos a = listaAlunos.get(i);
			System.out.println("ID: " + a.getId() + " Nome: " + a.getNome() + " Curso: " + a.getCurso() + " Nota: " + a.getNota());
		}
	}

	private static void buscarId() {
		if (listaAlunos.size() <= 0) {
			System.out.println("nao tem aluno cadastrados no momento");
			return;
		}
		System.out.println("digite o Id do aluno");
		int idbuscado = scan.nextInt();
		scan.nextLine();
		alunos encontrado = null;
		for (int i = 0; i < listaAlunos.size(); i++) {
			alunos a = listaAlunos.get(i);
			if (a.getId() == idbuscado) {
				encontrado = a;
				break;
			}
		}
		if (encontrado == null) {
			System.out.println("id nao encontrado");
		} else {
			System.out.println("ID:" + encontrado.getId() + " " + encontrado.getNome() + " " + encontrado.getCurso() + " " + encontrado.getNota());
		}
	}

	private static void atualizar() {
		if (listaAlunos.size() <= 0) {
			System.out.println("nao tem aluno cadastrados no momento");
			return;
		}
		System.out.println("digite o Id do aluno");
		int idbuscado = scan.nextInt();
		scan.nextLine();
		alunos encontrado = null;
		for (int i = 0; i < listaAlunos.size(); i++) {
			alunos a = listaAlunos.get(i);
			if (a.getId() == idbuscado) {
				encontrado = a;
				break;
			}
		}
		if (encontrado == null) {
			System.out.println("id nao encontrado");
		} else {
			
				System.out.println("novo nome do aluno");
				String nome = scan.nextLine();
				encontrado.setNome(nome);
				System.out.println("novo curso do aluno");
				String curso = scan.nextLine();
				encontrado.setCurso(curso);
				System.out.println("nova Nota do aluno");
				double nota = scan.nextDouble();
				encontrado.setNota(nota);
				scan.nextLine();
				System.out.println("cadastro atualizado");
		}
	}

	private static void removerCadastro() {
		if (listaAlunos.size() <= 0) {
			System.out.println("nao tem aluno cadastrados no momento");
			return;
		}
		System.out.println("digite o Id do aluno");
		int idbuscado = scan.nextInt();
		scan.nextLine();
		alunos encontrado = null;
		for (int i = 0; i < listaAlunos.size(); i++) {
			alunos a = listaAlunos.get(i);
			if (a.getId() == idbuscado) {
				encontrado = a;
				break;
			}
		}
		if (encontrado == null) {
			System.out.println("id nao encontrado");
		} else {
			listaAlunos.remove(encontrado);
		System.out.println("Aluno removido!");
	}
}
	}
