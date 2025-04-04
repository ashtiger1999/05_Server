package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el/check")
public class ELTestServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println(req.getAttribute("requestValue")); // null
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/check.jsp");
		dispatcher.forward(req, resp);
	}
}
