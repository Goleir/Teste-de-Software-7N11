import java.util.ArrayList;
import labtdd.Carrinho;
import labtdd.CarrinhoVazioExpected;
import labtdd.Produto;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	@Test(expected = CarrinhoVazioExpected.class)
	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { null }, new Object[] { menor });
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
		Produto livro = new Produto("Java em 24 horas", 50.00);
		carrinho.add(livro);
		Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
		Produto menor;
		menor = carrinho.menorProduto();
		assertArrayEquals(new Object[] { livro }, new Object[] { menor });
	}

	@Test
	public void identidadeDeProdutos() throws CarrinhoVazioExpected {
		Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
		Produto copia = new Produto("Java em 24 horas", 50.00);
		original = carrinho.menorProduto();
		assertArrayEquals(new Object[] { original }, new Object[] { copia });
	}

        @Test
        public void listarProdutos() throws CarrinhoVazioExpected {
                Produto original = new Produto("Java em 24 horas", 50.00);
		carrinho.add(original);
                
                Produto deitel = new Produto("Java: como programar", 150.00);
		carrinho.add(deitel);
                
                ArrayList<Produto> lista = new ArrayList<Produto>();
                assertEquals(lista.getClass(), carrinho.getProdutos().getClass());
        }
        
        @Test
    public void removerUmProduto() throws CarrinhoVazioExpected {
        Produto p1 = new Produto("Produto1", 10.00);
        Produto p2 = new Produto("Produto2", 20.00);
        carrinho.add(p1);
        carrinho.add(p2);

        carrinho.remove(p2);

        assertEquals(1, carrinho.getProdutos().size());
    }

    @Test
    public void removerTodosOsProdutos() throws CarrinhoVazioExpected {
        Produto p1 = new Produto("Produto1", 10.00);
        Produto p2 = new Produto("Produto2", 20.00);
        Produto p3 = new Produto("Produto3", 30.00);
        carrinho.add(p1);
        carrinho.add(p2);
        carrinho.add(p3);
        
        carrinho.limpar();
        
        assertEquals(0, carrinho.getProdutos().size());
    }
    
    @Test
    public void calcularValorTotalDoCarrinho() throws CarrinhoVazioExpected {
        Produto p1 = new Produto("Produto1", 20.00);
        Produto p2 = new Produto("Produto2", 20.00);
        Produto p3 = new Produto("Produto3", 30.00);
        
        carrinho.add(p1);
        carrinho.add(p2);
        carrinho.add(p3);
        
        double soma = carrinho.getPrecoTotal();
        
        assertEquals(70.0, soma, 0); 
    }

}

