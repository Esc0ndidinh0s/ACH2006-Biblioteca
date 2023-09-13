package com.biblioteca;

import org.junit.runners.JUnit4;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.ArrayList;

@RunWith(JUnit4.class)
public class VendaTest {
    /**
     * Test do construtor com parâmetros
     */
    @Test
    public void testConstrutorComParametros() {
        String nomeCliente = "Matheus Moreira";
        String formaPagamento = "Dinheiro";
        double valorDado = 23.5;
        List<LivroVenda> livros = new ArrayList<LivroVenda>();
        Venda venda = new Venda(nomeCliente, formaPagamento, valorDado, livros);
        Assert.assertNotNull(venda.nomeCliente);
        Assert.assertNotNull(venda.formaPagamento);
        Assert.assertNotNull(venda.valorDado);
        Assert.assertNotNull(venda.livros);
        Assert.assertEquals(venda.nomeCliente, nomeCliente);
        Assert.assertEquals(venda.formaPagamento, formaPagamento);
        Assert.assertEquals(venda.valorDado, valorDado, 0.1);
        Assert.assertArrayEquals(livros.toArray(), venda.livros.toArray());
    }

    @Test
    public void testConstrutorPadrao() {
        Venda venda = new Venda();
        Assert.assertNull(venda.nomeCliente);
        Assert.assertNull(venda.formaPagamento);
        Assert.assertEquals(venda.valorDado, 0, 0);
        Assert.assertNull(venda.livros);
    }
}