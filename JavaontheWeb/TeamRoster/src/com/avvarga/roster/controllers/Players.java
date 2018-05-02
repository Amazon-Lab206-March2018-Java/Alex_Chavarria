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

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Player newPlayer = new Player(request.getParameter("first_name"), request.getParameter("last_name"), Integer.parseInt(request.getParameter("age")));
		Team currentTeam = (Team) session.getAttribute("currentTeam");
		ArrayList<Player> players = currentTeam.getPlayers();
		players.add(newPlayer);
		currentTeam.setPlayers(players);
		session.setAttribute("players", currentTeam.getPlayers());
		response.sendRedirect("/TeamRoster/Home");
	}

}
