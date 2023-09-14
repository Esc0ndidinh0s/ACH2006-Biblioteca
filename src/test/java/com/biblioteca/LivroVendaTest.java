package com.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class LivroVendaTest {
    @Test
    public void testConstrutorComParametros() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        Assert.assertEquals(livro, livroEstoque.livro);
        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(2, livroVenda.quantidade);
    }

    @Test
    public void testConstrutorPadrao() {
        LivroVenda livroVendaPadrao = new LivroVenda();
        Assert.assertNull(livroVendaPadrao.livroDoEstoque);
        Assert.assertEquals(0, livroVendaPadrao.quantidade);
    }

    @Test
    public void testIncrementarQuantidadePadraoLivroVenda() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        livroVenda.IncrementarQuantidade();

        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(3, livroVenda.quantidade);
    }

    @Test
    public void testIncrementarQuantidadeComParametroLivroVenda() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        livroVenda.IncrementarQuantidade(10);

        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(12, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeSemParametroLivroVendaQuantidadeDisponivel() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        Assert.assertTrue(livroVenda.DecrementarQuantidade());
        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(1, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeSemParametroLivroVendaQuantidadeIndiponivel() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);

        Assert.assertFalse(livroVenda.DecrementarQuantidade());
        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(0, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeComParametroLivroVendaQuantidadeIndiponivel() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        Assert.assertFalse(livroVenda.DecrementarQuantidade(3));
        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(2, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeComParametroLivroVendaQuantidadeDisponivel() {
        Autor autor = new Autor("Nome do Autor", "Sobrenome do autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 50.0);

        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        Assert.assertTrue(livroVenda.DecrementarQuantidade(2));
        Assert.assertEquals(livroEstoque, livroVenda.livroDoEstoque);
        Assert.assertEquals(0, livroVenda.quantidade);
    }
}
