package com.msa2024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet(urlPatterns = { "/hello" }, initParams = { @WebInitParam(name = "a", value = "10") })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		System.out.println("생성자 호출");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초의 한번만 호출되는 init");

		// init으로 만든 a 값을 가져오는 방법
		System.out.println("a = " + config.getInitParameter("a"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name"); // param
		System.out.println("get 방법으로 호출 될 때 실행됨");
		System.out.println("name =" + name);
		
		// 처리 로직
		int a = 10;
		int b = 20;
		int result = a + b; // 이 결과를 JSP에 보내고 싶다.
		
		Users users = new Users();
		users.setUserid("hong");
		users.setUserpassword("1004");
		users.setUsername("홍길동");
		users.setUserage(10);
		users.setUseremail("hong@naver.com");
		
		// 포워딩
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("result", result);
		request.setAttribute("users", users);
		
		// Map 객체를 포워딩하기
		Map<String,String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", "200");
		map.put("job", "도적");
		
		request.setAttribute("map", map);
		
		// 배열로 객체 설정
		List<Users> list = new ArrayList<Users>();
		for(int i = 0 ; i < 10; i++) {
			Users obj = new Users();
			obj.setUserid("hong" + i);
			obj.setUserpassword("1004");
			obj.setUsername("홍길동" + i);
			obj.setUserage(10 + i);
			obj.setUseremail("hong@naver.com");
			if(i%2 == 0) obj.setNumberLabel("짝수");
			else obj.setNumberLabel("홀수");
			
			list.add(obj);
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/getView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name"); // param
		System.out.println("post방법으로 호출할 때 실행됨");
		System.out.println("name =" + name);
		
		// 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/postView.jsp");
		rd.forward(request, response);
	}

}
