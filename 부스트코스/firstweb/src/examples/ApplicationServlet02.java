package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationServlet02
 */
@WebServlet("/ApplicationServlet02")
public class ApplicationServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;chartset=UTF-5");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();
		
		try {
			// application scope에 맡긴 value값을 가져와서 1을 더한다.
			int value = (int) application.getAttribute("value");
			value++;
			
			application.setAttribute("value", value);
			
			out.println("<h1>value : " + value + "</h1>");
		} catch (NullPointerException e) {
			e.printStackTrace();
			out.println("NullPointerException");
		}

	}

}
