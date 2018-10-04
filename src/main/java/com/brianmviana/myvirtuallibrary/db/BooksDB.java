package com.brianmviana.myvirtuallibrary.db;

import java.sql.SQLException;

import com.brianmviana.myvirtuallibrary.utils.Status;

import totalcross.db.sqlite.SQLiteUtil;
import totalcross.io.IOException;
import totalcross.sql.PreparedStatement;
import totalcross.sql.ResultSet;
import totalcross.sql.Statement;
import totalcross.sys.Settings;
import totalcross.ui.image.ImageException;

public class BooksDB {

	private static BooksDB db = new BooksDB();
	private SQLiteUtil con;

	private BooksDB() {
		try {
			con = new SQLiteUtil(Settings.appPath, "books.db");
			createTables();
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
	
	public static BooksDB getInstance() {
		return db;
	}
	
	private void createTables() throws SQLException {
		try (Statement st = con.con().createStatement()) {
			//table user
			st.execute("create table if not exists book (id integer NOT NULL, titulo varchar, isbn varchar, editora varchar, photo blob, status varchar, PRIMARY KEY (ID))");
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
		try (PreparedStatement addUserSt = con.prepareStatement("insert into book (titulo, isbn, editora, status) values (?,?,?)")) {

			addUserSt.setString(1, "Teste 1");
			addUserSt.setString(2, "43243n3342344bu342");
			addUserSt.setString(3, "Moderna");
			addUserSt.setString(4, Status.ALL);
			addUserSt.addBatch();

			addUserSt.setString(1, "Teste 2");
			addUserSt.setString(2, "43gfdfa4bu342");
			addUserSt.setString(3, "test 2");
			addUserSt.setString(4, Status.ALL);
			addUserSt.addBatch();
			
			addUserSt.setString(1, "Teste 3");
			addUserSt.setString(2, "43243sad42");
			addUserSt.setString(3, "test 3");
			addUserSt.setString(4, Status.READ);
			addUserSt.addBatch();

			addUserSt.setString(1, "Teste 4");
			addUserSt.setString(2, "43243nsadaasd2");
			addUserSt.setString(3, "test 4");
			addUserSt.setString(4, Status.READ);
			addUserSt.addBatch();

			addUserSt.setString(1, "Teste 5");
			addUserSt.setString(2, "43243nsadge342");
			addUserSt.setString(3, "test 6");
			addUserSt.setString(4, Status.READING);
			addUserSt.addBatch();

			addUserSt.setString(1, "Teste 6");
			addUserSt.setString(2, "43243nsage342");
			addUserSt.setString(3, "test 7");
			addUserSt.setString(4, Status.NOTREAD);
			addUserSt.addBatch();
			
			addUserSt.setString(1, "Teste 7");
			addUserSt.setString(2, "4324gdg4bu342");
			addUserSt.setString(3, "test 8");
			addUserSt.setString(4, Status.NOTREAD);
			addUserSt.addBatch();
			
			addUserSt.setString(1, "Teste 8");
			addUserSt.setString(2, "4324sdfadadg2");
			addUserSt.setString(3, "test 9");
			addUserSt.setString(4, Status.ABANDONED);
			addUserSt.addBatch();

			addUserSt.setString(1, "Teste 9");
			addUserSt.setString(2, "43243nsada4bgdsg2");
			addUserSt.setString(3, "test 9");
			addUserSt.setString(4, Status.READ);
			addUserSt.addBatch();

			addUserSt.executeBatch();
		}
	}
	
	
}
