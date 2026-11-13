package cadastrarAlunos;

public class alunos {

private int id;
private double nota;
private String nome;
private String curso;


public alunos(int id, double nota, String nome, String curso) {
	super();
	this.id = id;
	this.nota = nota;
	this.nome = nome;
	this.curso = curso;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getNota() {
	return nota;
}
public void setNota(double nota) {
	this.nota = nota;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}

	}

