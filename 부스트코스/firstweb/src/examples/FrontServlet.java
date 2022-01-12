package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// NextServlet으로 값을 보내보자
		int diceValue = (int)(Math.random() * 6) + 1;
	
		// request객체에 변수 값을 저장한다.
		request.setAttribute("dice", diceValue);
		
		// 포워드하는 코드 작성
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next"); 
		// getRequestDispatcher()는 슬러시 /로 시작하여 WebContent 폴더 밑으로의 경로를 지정한다.
		
		requestDispatcher.forward(request, response);
		// requestDispatcher.forward 반드시 요청, 응답을 넘겨주어야한다. 그래야 해당 요청과 응답을 사용하여 결과를 얻어낼 수 있다.
		
	}

}
