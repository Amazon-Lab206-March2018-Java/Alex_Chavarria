package com.avvarga.animals.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.avvarga.animals.models.Cat;
import com.avvarga.animals.models.Dog;

/**
 * Servlet implementation class Dog
 */
@WebServlet("/ShowAnimal")
public class ShowAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		int weight = Integer.parseInt(request.getParameter("weight"));
		String animal = request.getParameter("animal");
		
		if (animal.equals("dog")) {
			
			Dog dog = new Dog(name, breed, weight);
			
			request.setAttribute("dog", dog);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Dog.jsp");
			view.forward(request, response);
		}
		
		else {
			System.out.println(animal);
			Cat cat = new Cat(name, breed, weight);
			
			request.setAttribute("cat", cat);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Cat.jsp");
			view.forward(request, response);
			
			
		}
	}

}
