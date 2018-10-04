package com.brianmviana.myvirtuallibrary.model;

import totalcross.ui.image.Image;

public class Book {
	private String titulo;
	private String isbn;
	private String editora;
	private Image capa;
	private String status;
	
	public Book() {};
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Image getCapa() {
		return capa;
	}
	public void setCapa(Image capa) {
		this.capa = capa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
