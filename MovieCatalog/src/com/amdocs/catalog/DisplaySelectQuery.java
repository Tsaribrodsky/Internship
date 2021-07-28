package com.amdocs.catalog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;
import com.amdocs.config.DatabaseConnection;

public class DisplaySelectQuery {

	public static String selectGenres() {

		Connection con = null; // establish connection with database connection
		JSONArray array = new JSONArray();

		try {

			con = DatabaseConnection.DBConnect();
			String query = "SELECT * FROM genres"; // Query for genres table

			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", resultSet.getInt("genre_id"));
				jsonObject.put("Genre", resultSet.getString("genre"));

				array.put(jsonObject);

			}

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
		return array.toString();
	}
}
