import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach
    public void setUp(){
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }

    @Test
    public void adicionaVariasPizzasCorretamente(){
       
        //act
        int quantidade = pedido.adicionarPizza(new Pizza());

        //assert
        assertEquals(2, quantidade);

    }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void calculaValorPedidoCorretamente(){

        //act
        double preco = pedido.precoAPagar();

        //assert
        assertEquals(29d, preco, 0.01);

    }

    @Test
    public void calculaPrecoPedidoComVariasPizzas(){

        //arrange
        Pizza pizza2ingrediente = new Pizza(2);
        pedido.adicionarPizza(pizza2ingrediente);

        //act
        double preco = pedido.precoAPagar();

        //assert
        assertEquals(68d, preco, 0.01);

    }

    @Test
    public void gerarRelatorioPedido(){
        
        String cupom = pedido.relatorio();
        assertTrue(
        cupom.contains("29,00") &&
        cupom.contains("1 pizza") &&
        cupom.contains("aberto")
        );

    }

}
