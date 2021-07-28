package com.amdocs.catalog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.amdocs.config.DatabaseConnection;

public class UpdateQuery {
	
	public static String upGenre() throws IOException {

		Connection con = null;

		try {

			con = DatabaseConnection.DBConnect();
			String updateGenreQuery = "UPDATE genres SET genre='danyGenre' WHERE genre_id=7";

			Statement statement = con.createStatement();
			
			statement.executeUpdate(updateGenreQuery);
			return "Genre updated successfully";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "final";
	}

}
