package Helpers;

import java.sql.*;
public class DBConnection {
	Connection c =null;
	public DBConnection() {}
	public Connection connDb() {
	    try {
	        this.c=DriverManager.getConnection("jdbc:mysql://localhost:3306/night_lords_stok_takip","root","1234");
	        return c;

	    } catch (SQLException e) {
	      
	        e.printStackTrace();
	    }
	    return c;

	}
}
