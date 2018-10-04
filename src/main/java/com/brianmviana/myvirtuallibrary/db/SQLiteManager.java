package com.brianmviana.myvirtuallibrary.db;

import java.sql.SQLException;
import java.util.ArrayList;

import com.brianmviana.myvirtuallibrary.model.Book;

import totalcross.db.sqlite.SQLiteUtil;
import totalcross.sql.PreparedStatement;
import totalcross.sql.ResultSet;
import totalcross.sql.Statement;
import totalcross.sys.Settings;

public class SQLiteManager {
	
	private static SQLiteManager instance = null;
	private SQLiteUtil util;
	
	private SQLiteManager() {
		
		try {
			util = new SQLiteUtil(Settings.appPath,"books.db");
			createBookTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static SQLiteManager getInstance() {
		
		if(instance == null) {
			instance = new SQLiteManager();
		}
		
		return instance;
	}

	public void createBookTable() {
		
		try {
			
			Statement st = util.con().createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS books (TITULO VARCHAR(50), ISBN VARCHAR(15), EDITORA VARCHAR(20), STATUS VARCHAR(20))");
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(String titulo) {
		try {
			Statement st = util.con().createStatement();
			st.execute("Delete from books where TITULO = 'titulo' ");
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Boolean insertBooks(Book book) {
		
		Boolean success = true;
		
		try {
		
			String sql = "INSERT INTO books VALUES (?,?,?,?)";
			PreparedStatement st = util.con().prepareStatement(sql);
			
			st.setString(1, book.getTitulo());
			st.setString(2, book.getIsbn());
			st.setString(3, book.getEditora());
			st.setString(4, book.getStatus());
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public ArrayList<Book> getBooks() {
		
		ArrayList<Book> books = new ArrayList<>();
		
		try {
			
			Statement st = util.con().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM books");
			
			while (rs.next()){
				
				Book book = new Book();
				book.setTitulo(rs.getString("TITULO"));
				book.setIsbn(rs.getString("ISBN"));
				book.setEditora(rs.getString("EDITORA"));
				book.setStatus(rs.getString("STATUS"));
				
				books.add(book);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
}

