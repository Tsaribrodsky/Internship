package com.amdocs.catalog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.amdocs.config.DatabaseConnection;
import com.amdocs.catalog.DisplaySelectQuery;
import com.amdocs.catalog.DisplayInsertQuery;
import com.amdocs.catalog.DisplayDeleteQuery;
import com.amdocs.catalog.DisplayUpdateQuery;

public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Display() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();

		String lastPathParam = request.getServletPath();

		printWriter.println(lastPathParam);
//		if (lastPathParam.equals("/display/update"))
		if (lastPathParam.equals("/display/select"))
//		if (lastPathParam.equals("/display/delete")) 
			{

			printWriter.println(DisplaySelectQuery.selectGenres());
//			printWriter.println(DisplayDeleteQuery.deleteGenre());
//			printWriter.println(UpdateQuery.upGenre());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		String lastPathParam = request.getServletPath();
		
		if (lastPathParam.equals("/display/insert"))
		{

			// String body = new BufferedReader();
			BufferedReader body = request.getReader();
			printWriter.println(DisplayInsertQuery.insertGenre(body));

		}

	}

}