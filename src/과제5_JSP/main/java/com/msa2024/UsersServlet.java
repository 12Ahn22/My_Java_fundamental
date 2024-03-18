package com.msa2024;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersServlet
 */
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO = new UsersDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	// 공통 처리 함수
	private void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "list" -> list(request, response);
		case "view" -> view(request, response);
		case "delete" -> delete(request, response);
		case "updateForm" -> updateForm(request, response);
		case "update" -> update(request, response);
		case "insert" -> insert(request, response);
		}
		// 3. jsp 포워딩
		// 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/users/" + action + ".jsp");
		rd.forward(request, response);

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String userage = request.getParameter("userage");
		String useremail = request.getParameter("useremail");
		
		Users users = new Users(userid, username, userpassword, Integer.parseInt(userage) , useremail);
		int updated = usersDAO.insert(users);
		
		request.setAttribute("updated", updated);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String userage = request.getParameter("userage");
		String useremail = request.getParameter("useremail");
		
		Users users = new Users(userid, username, userpassword, Integer.parseInt(userage) , useremail);
		int updated = usersDAO.update(users);
		
		request.setAttribute("updated", updated);
		request.setAttribute("userid", userid);
	}

	private void updateForm(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		// 1.처리
		Users user = usersDAO.read(userid);
		// 2. 출력할 jsp 값 설정
		request.setAttribute("user", user);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		int updated = usersDAO.delete(userid);
		request.setAttribute("updated", updated);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("목록");

		// 1. 처리
		List<Users> list = usersDAO.list();
		// 2. jsp출력할 값 설정
		request.setAttribute("list", list);

		// 3. jsp 포워딩
		// 포워딩
//      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/users/list.jsp");
//      rd.forward(request, response);
	}

	private void view(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		// 1.처리
		Users user = usersDAO.read(userid);
		// 2. 출력할 jsp 값 설정
		request.setAttribute("user", user);
	}

}
