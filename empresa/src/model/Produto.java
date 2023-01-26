package model;

public class Produto {

	private int codigo;
	private String nome;
	private double precoUnitario;
	private int quantEstoque;
	
	public Produto() {

	}
	
	public Produto(int codigo, String nome, double precoUnitario, int quantEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantEstoque = quantEstoque;
	}

	public String toString() {
		return "["+codigo+","+nome+","+precoUnitario+","+quantEstoque+"]";
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQuantEstoque() {
		return quantEstoque;
	}
	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}
	
	
}
