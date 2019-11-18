package com.rlsp.socialbooks.client.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Comment {

	private Long id;

	private String texto;

	private String usuario;	

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;

	private Book livro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Book getLivro() {
		return livro;
	}
	public void setLivro(Book livro) {
		this.livro = livro;
	}
	

	
}
