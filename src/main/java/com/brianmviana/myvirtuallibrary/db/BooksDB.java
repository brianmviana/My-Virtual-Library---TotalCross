package com.brianmviana.myvirtuallibrary.db;

import java.sql.SQLException;

import totalcross.db.sqlite.SQLiteUtil;
import totalcross.io.IOException;
import totalcross.sql.PreparedStatement;
import totalcross.sql.ResultSet;
import totalcross.sql.Statement;
import totalcross.sys.Settings;
import totalcross.ui.image.ImageException;

public class BooksDB {

	private static BooksDB db = new BooksDB();
	private SQLiteUtil util;

	private BooksDB() {
		try {
			util = new SQLiteUtil(Settings.appPath, "books.db");
			createTables();
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
	
	public static BooksDB getInstance() {
		return db;
	}
	
	private void createTables() throws SQLException {
		try (Statement st = util.con().createStatement()) {
			//table user
			st.execute("create table if not exists book (id integer NOT NULL, titulo varchar, nomeAutor varchar,"
					+ "isbn varchar, paginas int, editora varchar, photo blob, PRIMARY KEY (ID))");
			//table restaurant 
			
			try (ResultSet testUser = st.executeQuery("select * from user")) {
				if (!testUser.next()) {
					try {
						populate();
					} catch (ImageException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void populate() throws SQLException, ImageException, IOException {
		//add Books
		try (PreparedStatement addUserSt = util.prepareStatement("insert into book (titulo, nomeAutor, isbn, paginas, editora) values (?,?,?,?,?)")) {

			addUserSt.setString(1, "Teste 1");
			addUserSt.setString(2, "Fulano");
			addUserSt.setString(3, "43243n3342344bu342");
			addUserSt.setInt(4, 500);
			addUserSt.setString(5, "Moderna");
			addUserSt.addBatch();
			
			addUserSt.executeBatch();
		}
	}
	
	
}
