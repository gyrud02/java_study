package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1~100까지 랜덤한 두 값 구하여 그 두 값을 더하는 코드를 완성해보자.
	
		// 1. 랜덤한 두 값을 구해보자.
		int v1 = (int) (Math.random() * 100) + 1;
		int v2 = (int) (Math.random() * 100) + 1;
		int result = v1 + v2;
		
		// 2. 포워딩을 하기 위해 값을 request 객체에 저장해놓는다.
		request.setAttribute("v1", v1);
		request.setAttribute("v2", v2);
		request.setAttribute("result", result);
		
		// 3. 포워딩을 하기 위해 RequestDispatcher 객체를 생성하여 값을 보낼 페이지로 경로를 지정한다.
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
		
		// 4. 포워딩을 한다.
		requestDispatcher.forward(request, response);
		
	}

}
