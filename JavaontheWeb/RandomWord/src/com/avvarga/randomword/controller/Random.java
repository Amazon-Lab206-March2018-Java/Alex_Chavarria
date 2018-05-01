package com.avvarga.randomword.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomWordGenerator
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String word = "";
		for (int i=0; i<10; i++) {
			int character = (int)(Math.random()*characters.length());
			word+=(characters.charAt(character));
		}
		session.setAttribute("word", word);
		session.setAttribute("time", LocalDateTime.now());
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        view.forward(request, response);
	}
        

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
