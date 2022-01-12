package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextServlet
 */
@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// FrontServlet에서 넘겨받은 값을 출력한다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>ForWard 실습</title></head>");
		out.println("<body>");
		
		int dice = (int) request.getAttribute("dice");

		for(int i = 0; i < dice; i++){
			out.print("<br> hello !! forward <br>");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		// 리다이렉트는 정해놓은 페이지로 URL이 바뀐다.
		// 포워딩은 URL이 바뀌지 않는다. next로 매핑을 했지만 출력했을 때 URL은 /front로 나오는 것을 볼 수 있다.
		// 리다이렉트는 요청 횟수가 두 번 이상이 될 수 있지만, 포워딩의 요청은 한 번이다.
	}

}
