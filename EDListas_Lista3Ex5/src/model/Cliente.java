package model;

public class Cliente {

	public String cpf;
	public String nome;
	public String idade;
	public String limiteCredito;
	
	public Cliente(String cpf, String nome, String idade, String limiteCredito) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.limiteCredito = limiteCredito;
	}

	public String getCPF() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getIdade() {
		return idade;
	}

	public String getLimiteCredito() {
		return limiteCredito;
	}

	
}
