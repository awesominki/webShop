package controller;

import dto.BoardVO;
import model.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	//�Է�form�����ֱ� 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	
	   RequestDispatcher rd;
	   rd = request.getRequestDispatcher("boardInsert.jsp");
	   rd.forward(request, response);
	}

	//�Էµ� data�� DB�� �������� 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = Integer.parseInt(request.getParameter("writer"));
		
		BoardVO board = new BoardVO(0, title, content, writer, null, null);
		BoardService service = new BoardService();
		int result = service.insert(board);

		response.sendRedirect("boardlist.do");

		//redirect : 요청 주소창을 바꾼다.
		//forward : 요청 주소창을 바꾸지 않는다. 요청과 응답이 다른문서이다.

//		String message = "insert����";
//		if(result>0)  message = "insert����";
//		request.setAttribute("message", message);
//		RequestDispatcher rd ;
//		rd = request.getRequestDispatcher("result.jsp");
//		rd.forward(request, response);
	}

}






