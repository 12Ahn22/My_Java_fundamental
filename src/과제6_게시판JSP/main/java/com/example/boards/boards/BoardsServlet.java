package 과제6_게시판JSP.main.java.com.example.boards.boards;

import com.example.boards.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BoardsServlet", value = "/BoardsServlet")
public class BoardsServlet extends HttpServlet {
    private BoardsDAO boardsDAO = new BoardsDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

    private void doService(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); // 한글 설정

        String action = request.getParameter("action");
        switch(action) {
            case "list" -> list(request, response);
            case "view" -> view(request, response);
            case "delete" -> delete(request, response);
            case "updateForm" -> updateForm(request, response);
            case "update" -> update(request, response);
            case "insertForm" -> insertForm(request, response);
            case "insert" -> insert(request, response);
        }

        //포워딩
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/boards/"+action+".jsp");
        rd.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("등록");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        Boards boards = new Boards(null, title, content, writer, null);
        int updated = boardsDAO.insert(boards);
        request.setAttribute("updated", updated);
    }

    private void insertForm(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("생성화면");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("수정");
        String bno = request.getParameter("bno");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String date = request.getParameter("date");

        Boards boards = new Boards(bno, title, content, writer,date);

        //1. 처리
        int updated = boardsDAO.update(boards);

        //2. jsp출력할 값 설정
        request.setAttribute("updated", updated);
        request.setAttribute("bno", bno);
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("수정화면");
        String bno = request.getParameter("bno");
        //1. 처리
        Boards boards = boardsDAO.read(bno);

        //2. jsp출력할 값 설정
        request.setAttribute("board", boards);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("삭제");
        String bno = request.getParameter("bno");
        //1. 처리
        int updated = boardsDAO.delete(bno);

        //2. jsp출력할 값 설정
        request.setAttribute("updated", updated);
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("VIEW");
        String bno = request.getParameter("bno");
        //1. 처리
        Boards board = boardsDAO.read(bno);

        //2. jsp출력할 값 설정
        request.setAttribute("board", board);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("목록");

        //1. 처리
        List<Boards> list = boardsDAO.list();

        //2. jsp출력할 값 설정
        request.setAttribute("list", list);
    }
}
