package labtdd;

import java.util.ArrayList;

public class Carrinho {

	private ArrayList<Produto> produtos;

	public Carrinho() {
		produtos = new ArrayList<Produto>();
	}

	public void add(Produto produto) {
		produtos.add(produto);
	}

	public Produto menorProduto() throws CarrinhoVazioExpected {
		if (produtos.size() == 0)
			throw new CarrinhoVazioExpected();
		Produto menor = produtos.get(0);
		for (Produto produto : produtos) {
			if (produto.getPreco() < menor.getPreco())
				menor = produto;
		}
		return menor;
	}
        
        public ArrayList<Produto> getProdutos(){
            return this.produtos;
        }

}
