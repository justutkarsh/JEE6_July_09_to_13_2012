package com.durasoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durasoft.domain.GuessingGame;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GuessingGame guessingGame;
	public GameServlet(){
		guessingGame = new GuessingGame();
	}
	private String getOutput(){
		String output = "<html>";
		output += "<body>";
		if(!guessingGame.isGameOver()){
			output += "<form action='game' method='post'>";
			output += "Enter your guess <input type='text' name='guess'><br/>";
			output += "<input type='submit' value='Guess'>";
			output += "</form>";
		}
		output += "<h2>" + guessingGame.getMessage() + "</h2>";
		output += "<h2>Attempts: " + guessingGame.getAttempts() + "</h2>";
		output += "<body>";
		output += "</html>";
		return output;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int guess = Integer.parseInt(request.getParameter("guess"));
		guessingGame.play(guess);
		String output = getOutput();
		PrintWriter out = response.getWriter();
		out.println(output);
	}
}
