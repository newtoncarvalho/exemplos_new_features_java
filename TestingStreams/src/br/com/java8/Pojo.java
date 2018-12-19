package br.com.java8;

public class Pojo {
	
	private int id;
	private String nome;
	private String sobrenome;
	
	public Pojo() {}
	
	public Pojo(int id, String nome, String sobrenome) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this != obj && obj instanceof Pojo) {
			return this.id == ((Pojo) obj).id;
		}			
		return super.equals(obj);
	}
	
	
}
