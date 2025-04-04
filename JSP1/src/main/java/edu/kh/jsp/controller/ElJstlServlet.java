package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el_jstl")
public class ElJstlServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1) JSP 경로 (webapp 폴더 기준)
		String psth = "/WEB-INF/views/el_jstl.jsp";
		
		// 2) 요청 발송자 얻어오기
		RequestDispatcher dispatcher = req.getRequestDispatcher(psth);
		
		// 3) 요청 위임 (forward)
		dispatcher.forward(req, resp);
	}

}
