

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/spas/*")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.println("<h1 style=\"color:powderblue;\">Hello World!</h1>");
		String lastPathParam = request.getServletPath().replaceAll("/", "");
		out.print("<body style=\"font-size: 40px; color:white; text-align:center; background:blue; \">Hello "+ lastPathParam.toUpperCase() +"!</body>");
	
		
		String queryParams = request.getQueryString();
        if (queryParams != null) {
            out.println("<h1>Hello " + queryParams.toUpperCase() + "!</h1>");
        }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		BufferedReader buffer = new BufferedReader(request.getReader());
		out.print(buffer.readLine());
	}

}
