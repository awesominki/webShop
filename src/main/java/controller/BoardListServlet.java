package controller;

import dto.BoardVO;
import model.BoardService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/boardlist.do")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardService service = new BoardService();
        List<BoardVO> blist = service.selectAll();

        request.setAttribute("boardDatas",blist);

        //위임 (요청을 받은것은 Servlet인데 응답은 jsp로 한다)
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("boardList.jsp");
        rd.forward(request,response);
    }

}
