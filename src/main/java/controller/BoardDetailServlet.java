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

@WebServlet("/board/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String boardid = request.getParameter("boardid");
        int i_boardid = 0;
        System.out.println("boardid=" + boardid);

        if(boardid != null){
            i_boardid = Integer.parseInt(boardid);
        }

        BoardService boardService = new BoardService();
        BoardVO board = boardService.selectById(i_boardid);
        request.setAttribute("board",board);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("boardDetail.jsp");
        rd.forward(request,response);
    }
}
