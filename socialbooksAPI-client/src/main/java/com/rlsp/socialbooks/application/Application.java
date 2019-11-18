package com.rlsp.socialbooks.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.rlsp.socialbooks.client.BooksClient;
import com.rlsp.socialbooks.client.domain.Author;
import com.rlsp.socialbooks.client.domain.Book;

public class Application {
	
	public static void main(String[] args) {
		
		BooksClient booksClient = new BooksClient("http://localhost:8080","rlsp","12345");
		
		List<Book> listarBooks = booksClient.listarLivros();
		
		for (Book book : listarBooks) {
			System.out.println("Book Encontrado --> " + book.getNome());
		}
		
		//Author autor = new Author();
		Book book = new Book();
		book.setNome("GitHub in 21 days");
		book.setEditora("Canadian Publishing");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			book.setPublicacao(publicacao.parse("2011-02-15"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		book.setResumo("GitHub in 21 days - The easier way to learning Git");
		
		
		String localizacao = booksClient.salvar(book);
		
		System.out.println("URI book saved is ==: " + localizacao);		
		
		Book bookSearched = booksClient.buscarLivro(localizacao);
		
		System.out.println("Book searched ==> " + bookSearched.getNome());
			
	}	
	

}
