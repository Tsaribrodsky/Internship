package com.amdocs.catalog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.amdocs.config.DatabaseConnection;
import java.sql.Statement;

public class DisplayDeleteQuery {
	
	public static String deleteGenre() throws IOException {

		Connection con = null;

		try {

			con = DatabaseConnection.DBConnect();
			String delGenreQuery = "DELETE FROM genres WHERE genre_id = 11";

			Statement statement = con.createStatement();
			
			statement.executeUpdate(delGenreQuery);
			return "Genre deleted successfully";

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
