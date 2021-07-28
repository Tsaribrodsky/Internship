package com.amdocs.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection DBConnect() throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver");
		// Connection
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema", "postgres",
				"postgre");

		System.out.println("Connected to PostgreSQL database!");
		// Exception error handle
		return connection;
	}
}