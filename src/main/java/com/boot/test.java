package com.boot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		Class.forName("com.mysql.jdbc.Driver");
		/*MysqlDataSource ds = new MysqlDataSource ();
		ds.setServerName("localhost:3306");
		ds.setDatabaseName("localschema");
		ds.setUser("admin");
		ds.setPassword("admin");*/
		Connection con = DriverManager. getConnection("jdbc:mysql://localhost:3306/localschema" ,"admin","admin"); 
		Statement stmt = con.createStatement();

	}

}
