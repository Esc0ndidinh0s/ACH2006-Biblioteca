package com.biblioteca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BibliotecaTest {
    @Test
    public void testConstrutorSemParametros() {
        Biblioteca biblioteca = new Biblioteca();
        assertNotNull(biblioteca.getAutores());
        assertNotNull(biblioteca.getLivros());
        assertNotNull(biblioteca.getEditoras());
        assertNotNull(biblioteca.getEstoque());
    }
    
    @Test
    public void testAdicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        biblioteca.AdicionarLivro(livro);
        assertTrue(biblioteca.getLivros().contains(livro));
    }

    @Test
    public void testAdicionarAutor() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor();
        biblioteca.AdicionarAutor(autor);
        assertTrue(biblioteca.getAutores().contains(autor));
    }

    @Test
    public void testAdicionarEditora() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora();
        biblioteca.AdicionarEditora(editora);
        assertTrue(biblioteca.getEditoras().contains(editora));
    }

    @Test
    public void testAdicionarEstoque() {
        Biblioteca biblioteca = new Biblioteca();
        LivroEstoque livroEstoque = new LivroEstoque();
        biblioteca.AdicionarEstoque(livroEstoque);
        assertTrue(biblioteca.getEstoque().contains(livroEstoque));
    }

    @Test
    public void testRemoverLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        biblioteca.AdicionarLivro(livro);
        biblioteca.RemoverLivro(livro);
        assertFalse(biblioteca.getLivros().contains(livro));
    }

    @Test
    public void testRemoverAutor() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor();
        biblioteca.AdicionarAutor(autor);
        biblioteca.RemoverAutor(autor);
        assertFalse(biblioteca.getAutores().contains(autor));
    }

    @Test
    public void testRemoverEditora() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora();
        biblioteca.AdicionarEditora(editora);
        biblioteca.RemoverEditora(editora);
        assertFalse(biblioteca.getEditoras().contains(editora));
    }

    @Test
    public void testRemoverEstoque() {
        Biblioteca biblioteca = new Biblioteca();
        LivroEstoque livroEstoque = new LivroEstoque();
        biblioteca.AdicionarEstoque(livroEstoque);
        biblioteca.RemoverEstoque(livroEstoque);
        assertFalse(biblioteca.getEstoque().contains(livroEstoque));
    }
}
