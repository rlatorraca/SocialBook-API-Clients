package com.rlsp.socialbooks.client.domain;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Author {

	private Long id;

	private String name;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	private String nationality;

	private List<Book> books;
	
	public Author() {}
	
	public Author (String name, String nationality) {
		this.name = name;		
		this.nationality = nationality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return dob;
	}

	public void setDOB(Date dOB) {
		dob = dOB;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	
	
}
