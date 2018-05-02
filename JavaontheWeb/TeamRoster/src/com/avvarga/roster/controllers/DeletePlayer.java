package com.avvarga.roster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avvarga.roster.models.Player;
import com.avvarga.roster.models.Team;


@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Player> players = new ArrayList <Player> ();
		players = (ArrayList<Player>) session.getAttribute("players");
		Player player = players.get(Integer.parseInt(request.getParameter("id")));
		players.remove(player);
		session.setAttribute("players", players);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
