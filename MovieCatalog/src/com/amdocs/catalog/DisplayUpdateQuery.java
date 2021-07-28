package com.amdocs.catalog;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONObject;

import com.amdocs.config.DatabaseConnection;

public class DisplayUpdateQuery {
	
	public static String updateGenre(BufferedReader body) throws IOException {

		StringBuilder strBuilder = new StringBuilder();
		Connection con = null;
		String str;
		
		 while ((str = body.readLine()) != null) {
			 strBuilder.append(str);
	        }

		try {

			con = DatabaseConnection.DBConnect();
			String updateGenreQuery = "UPDATE genres SET genre='danyGenre' WHERE genre_id=7";

			
			JSONObject jsonObject = new JSONObject(strBuilder.toString());

			int genreId = jsonObject.getInt("genreId");
			String genre = jsonObject.getString("genre");
			System.out.println(genreId);
			System.out.println(genre);
			PreparedStatement statement = con.prepareStatement(updateGenreQuery);

			statement.setInt(1, genreId);
			statement.setString(2, genre);

			statement.executeUpdate();
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
