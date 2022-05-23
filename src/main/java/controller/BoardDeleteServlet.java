package controller;

import model.BoardService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/boardDelete.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	    int bno = Integer.parseInt(request.getParameter("bno"));
	    
	    BoardService service = new BoardService();
	    int result = service.delete(bno);
	    request.setAttribute("message", result>0?"삭제성공":"삭제실패");
	
	    //����
	    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
	    rd.forward(request, response);
	}

	 

}
