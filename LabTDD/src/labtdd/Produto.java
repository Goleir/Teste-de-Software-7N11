package labtdd;

public class Produto {

	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public boolean equals(Object obj) {
		Produto p = (Produto) obj;
		return nome.equals(p.nome);
	}

}