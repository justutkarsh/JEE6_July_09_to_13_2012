package com.durasoft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.durasoft.domain.GuessingGame;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int guess = Integer.parseInt(request.getParameter("guess"));
		GuessingGame game = null;
		HttpSession session = request.getSession(true);
		if(session.getAttribute("guessingGame") == null){
			game = new GuessingGame();
		}
		else{
			game = (GuessingGame)session.getAttribute("guessingGame");
		}
		game.play(guess);
		session.setAttribute("guessingGame", game);
		if(game.isGameOver()){
			session.removeAttribute("guessingGame");
			session.setAttribute("history",game.getHistory());
			request.setAttribute("gameOver","yes");
		}
		request.getRequestDispatcher("/game.jsp").forward(request,response);
	}
}
