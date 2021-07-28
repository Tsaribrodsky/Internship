package com.amdocs.calculator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import com.amdocs.calculator.validation.Validation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */

public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Calculator.class);
	private Validation validation;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		this.validation = new Validation();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.debug("START Calculator Servlet");

		PrintWriter out = response.getWriter();
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String lastPathParam = request.getServletPath();
		MDC.put("lastPathParam", lastPathParam);

		try {
			if (validation.isValid(a) && validation.isValid(b) && validation.isNumber(a) && validation.isNumber(b)) {
				double y = Double.parseDouble(b);
				double x = Double.parseDouble(a);
				logger.error("isValid, isNumber methods passed successfully");

				switch (lastPathParam) {
				case "/add":
					out.println(x + y);
					break;
				case "/sub":
					out.println(x - y);
					break;
				case "/mult":
					out.println(x * y);
					break;
				case "/div":
					out.println(x / y);
					break;
				default:
				}
			} else {
				out.println("Please, read the Calculator's rules");
			}
		} catch (NumberFormatException e) {
			logger.error("Error. You fail in life");
			out.println("You won 1 bitcoin");
		}
		logger.debug("END Calculator Servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
