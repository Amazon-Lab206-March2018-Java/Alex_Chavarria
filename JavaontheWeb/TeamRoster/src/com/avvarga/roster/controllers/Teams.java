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
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Teams() {
        super();
    }


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id")==null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
			view.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			if (session.getAttribute("players") == null) {
				session.setAttribute("players", new ArrayList<Player>());
			}
			ArrayList<Team> teams = new ArrayList <Team> ();
			teams = (ArrayList<Team>) session.getAttribute("teams");
			Team team = teams.get(Integer.parseInt(request.getParameter("id")));
			session.setAttribute("currentTeam", team);
			ArrayList<Player> players = team.getPlayers();
			session.setAttribute("players", players);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
			view.forward(request, response);
		}
		
	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Team newTeam = new Team(request.getParameter("team_name"));
		HttpSession session = request.getSession();
		ArrayList <Team> list = new ArrayList <Team>();
		if (session.getAttribute("teams")!=null) {
			list = (ArrayList<Team>) session.getAttribute("teams");
		}
		list.add(newTeam);
		session.setAttribute("teams", list);
		response.sendRedirect("/TeamRoster/Home");
	}

}
