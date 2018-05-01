package com.avvarga.greatnumbergame.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NumberController
 */
@WebServlet("/NumberController")
public class NumberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        view.forward(request, response);	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("number")==null) {
			session.setAttribute("number", (int)(Math.random()*100+1));
		}
		
		System.out.println(session.getAttribute("number"));
		int guess = Integer.parseInt(request.getParameter("guess"));
		if (guess == (int) session.getAttribute("number")) {
			session.setAttribute("won", "won");
			session.setAttribute("show", "block");
			session.setAttribute("result", session.getAttribute("number")+" was the right number!");
		}
		if (guess < (int) session.getAttribute("number")) {
			session.setAttribute("result", " Too low!");
		}
		if (guess > (int) session.getAttribute("number")) {
			session.setAttribute("result", " Too high!");
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        view.forward(request, response);
	}

}
