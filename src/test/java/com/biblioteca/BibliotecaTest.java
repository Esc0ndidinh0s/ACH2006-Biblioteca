package com.biblioteca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BibliotecaTest {
    @Test
    public void testConstrutorSemParametros() {
        Biblioteca biblioteca = new Biblioteca();
        assertNotNull(biblioteca.autores);
        assertNotNull(biblioteca.livros);
        assertNotNull(biblioteca.editoras);
        assertNotNull(biblioteca.estoque);
    }
    
    @Test
    public void testAdicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        livro.isbn = "test-isbn";
        Livro livro2 = new Livro();
        livro.isbn = "test2-isbn";
        biblioteca.AdicionarLivro(livro);
        biblioteca.AdicionarLivro(livro2);
        assertTrue(biblioteca.livros.contains(livro) && biblioteca.livros.contains(livro2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarLivroRepetido() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro();
        livro1.isbn = "test-isbn";
        Livro livro2 = new Livro();
        livro2.isbn = "test-isbn";
        biblioteca.AdicionarLivro(livro1);
        biblioteca.AdicionarLivro(livro2);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testAdicionarAutor() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("test-nome", "test-sobrenome");
        Autor autor2 = new Autor("test-nome-2", "test-sobrenome-2");
        Autor autor3 = new Autor("test-nome", "test-sobrenome-3");
        biblioteca.AdicionarAutor(autor);
        biblioteca.AdicionarAutor(autor2);
        biblioteca.AdicionarAutor(autor3);
        assertTrue(biblioteca.autores.contains(autor) && biblioteca.autores.contains(autor2) && biblioteca.autores.contains(autor3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarAutorRepetido() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor1 = new Autor("test-nome", "test-sobrenome");
        Autor autor2 = new Autor("test-nome", "test-sobrenome");
        biblioteca.AdicionarAutor(autor1);
        biblioteca.AdicionarAutor(autor2);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testAdicionarEditora() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora("test-editora");
        Editora editora2 = new Editora("test-editora2");
        biblioteca.AdicionarEditora(editora);
        biblioteca.AdicionarEditora(editora2);
        assertTrue(biblioteca.editoras.contains(editora) && biblioteca.editoras.contains(editora2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarEditoraRepetida() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora1 = new Editora("teste-editora");
        Editora editora2 = new Editora("teste-editora");
        biblioteca.AdicionarEditora(editora1);
        biblioteca.AdicionarEditora(editora2);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testAdicionarEstoque() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro();
        livro1.isbn = "test-isbn";
        Livro livro2 = new Livro();
        livro2.isbn = "test-2-isbn";
        LivroEstoque livroEstoque = new LivroEstoque(livro1, 10, 10);
        LivroEstoque livroEstoque2 = new LivroEstoque(livro2, 20, 2);
        biblioteca.AdicionarEstoque(livroEstoque);
        biblioteca.AdicionarEstoque(livroEstoque2);
        assertTrue(biblioteca.estoque.contains(livroEstoque) && biblioteca.estoque.contains(livroEstoque2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarEstoqueRepetido() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        livro.isbn = "isbn-test";
        LivroEstoque estoque1 = new LivroEstoque(livro, 1, 10);
        LivroEstoque estoque2 = new LivroEstoque(livro, 2, 20);
        biblioteca.AdicionarEstoque(estoque1);
        biblioteca.AdicionarEstoque(estoque2);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testRemoverLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        livro.isbn = "test-isbn";
        Livro livro2 = new Livro();
        livro2.isbn = "test-2-isbn";
        biblioteca.AdicionarLivro(livro);
        biblioteca.AdicionarLivro(livro2);
        biblioteca.RemoverLivro(livro);
        assertFalse(biblioteca.livros.contains(livro));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverLivroInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        livro.isbn = "test-isbn";
        biblioteca.RemoverLivro(livro);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testRemoverAutor() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("test-autor", "test-sobrenome-autor");
        Autor autor2 = new Autor("test-autor-2", "test-sobrenome-2");
        Autor autor3 = new Autor("test-autor", "test-sobrenome-3");
        biblioteca.AdicionarAutor(autor2);
        biblioteca.AdicionarAutor(autor);
        biblioteca.AdicionarAutor(autor3);
        biblioteca.RemoverAutor(autor);
        assertFalse(biblioteca.autores.contains(autor));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverAutorInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor();
        autor.nome = "test-autor";
        autor.sobrenome = "test-sobrenome-autor";
        biblioteca.RemoverAutor(autor);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testRemoverEditora() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora("test-editora");
        Editora editora2 = new Editora("test-editora-2");
        biblioteca.AdicionarEditora(editora);
        biblioteca.AdicionarEditora(editora2);
        biblioteca.RemoverEditora(editora);
        assertFalse(biblioteca.editoras.contains(editora));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverEditoraInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora();
        editora.nome = "test-editora";
        biblioteca.RemoverEditora(editora);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }

    @Test
    public void testRemoverEstoque() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro();
        livro.isbn = "test-isbn";
        Livro livro2 = new Livro();
        livro2.isbn = "test-isbn-2";
        LivroEstoque livroEstoque = new LivroEstoque(livro, 10, 2);
        LivroEstoque livroEstoque2 = new LivroEstoque(livro2, 5, 1);
        biblioteca.AdicionarEstoque(livroEstoque);
        biblioteca.AdicionarEstoque(livroEstoque2);
        biblioteca.RemoverEstoque(livroEstoque);
        assertFalse(biblioteca.estoque.contains(livroEstoque));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverEstoqueInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        LivroEstoque livroEstoque = new LivroEstoque();
        Livro livro = new Livro();
        livro.isbn = "test-isbn";
        livroEstoque.livro = livro;
        biblioteca.RemoverEstoque(livroEstoque);
        fail("Era esperada uma exceção do tipo IllegalArgumentException");
    }
}
