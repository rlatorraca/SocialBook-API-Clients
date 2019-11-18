package com.rlsp.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rlsp.socialbooks.client.domain.Book;

public class BooksClient {
	
	private RestTemplate restTemplate; // permite a criacao das requisicoes RESTFULL
	private String URI_BASE;
	private String URN_BASE = "/livros";
	private String credencial;
	
	public BooksClient(String url, String usuario, String senha) {
		restTemplate = new RestTemplate(); // permite a criacao das requisicoes RESTFULL
		URI_BASE = url.concat(URN_BASE);
		String credencialAux = usuario + ":" + senha;
		credencial =  "BASIC " + Base64.getEncoder().encodeToString(credencialAux.getBytes()); // transforma a cadeia de caracteres em Base64
	}

	public List<Book> listarLivros(){
			
				
		// Cria requisicao para ser enviada a API
		RequestEntity<Void> request = RequestEntity
										.get(URI.create(URI_BASE))
										.header("Authorization", credencial) // rlsp:12345 {base64 generator uused}
										.build(); // cria uma requisicao para a API com autenticacao criado na API Configure
		
			
		//Passa a requisicao ao API por por do restTemplatee.exchange e espera um BOOK[].class como resposta
		//Pega a resposta enviada pela API
		System.out.println(request.toString());
		ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);
		
		return Arrays.asList(response.getBody());
		
	}
	
	public String salvar(Book book) {
		
		
		
		//Cria a requisicao de POST enviada para o servidor
		RequestEntity<Book> requestSalvar = RequestEntity
					.post(URI.create(URI_BASE))
					.header("Authorization", credencial) // rlsp:12345 {base64 generator uused}
					.body(book); // cria uma requisicao para a API com autenticacao criado na API Configure
		
	
		// Nao exite retorno no pedido por isso o VOID (nao a retorna com  criacao do livro)
		// A resposta é vazia tbem "Void.class"
		ResponseEntity<Void> responseSalvar = restTemplate.exchange(requestSalvar, Void.class);
		
		//Retorna a LOCALIZACAO [http://localhost:8080/livro/{id}] do RECURSO criado
		return responseSalvar.getHeaders().getLocation().toString();
	}
	
	public Book buscarLivro (String uri) {
		
		
		
		RequestEntity<Void> requestSalvarLivro = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencial) // rlsp:12345 {base64 generator uused}
				.build();
		
		ResponseEntity<Book> responseBuscarLivro = restTemplate.exchange(requestSalvarLivro, Book.class);
		
		return responseBuscarLivro.getBody();
	}
}
