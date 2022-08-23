package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.DAO;
import com.revature.dl.GuessDAO;
import com.revature.dl.wordDAO;
import com.revature.models.Guess;
import com.revature.models.word;

public class PlayServlet extends HttpServlet{
	int bulls = 0;
	int cows = 0;
	
	
	private static DAO<word> wordDao = new wordDAO();
	private static DAO<Guess> guessDao = new GuessDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		String newGuess = req.getParameter("Guess");
		Guess brandNewGuess = new Guess(newGuess, bulls, cows);
		guessDao.addInstance(brandNewGuess);
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>"); 
        out.println("<title>Input Servlet</title>"); 
        out.println("</head>"); 
        out.println("<body>"); 
        out.println("<h1>THIS IS THE PLAY PAGE</h1>");   
        
		
		
		word secret_word = null;
		if(wordDao.findSecretWord() == null)
		{
			System.out.println("IN THE IF STATEMENT");
			wordDao.markSecretWord();
			
			
		}
		
		secret_word = wordDao.findSecretWord();
		
		out.println("<h1>THE SECRET WORD IS " + secret_word.getWordName() + "</h1>");
		
		
		out.println("<label>GUESS___</label><label>BULLS___</label><label>COWS___</label>");
		ArrayList<Guess> guesses = guessDao.getAllInstances();
		if(guesses.size() != 0)
		{
			for(Guess thisGuess: guessDao.getAllInstances())
			{
				out.println("<br><label>GUESS: " + thisGuess.getGuessName() + " BULLS: " + thisGuess.getBulls() + " COWS: "+ thisGuess.getCows() +"</label>");
			}
		}
		
		
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/play\">");
		out.println("<br><input type = \"text\" name = \"Guess\" size = 5>");
		out.println("<input type = \"submit\" value = \"GUESS\">");
		
		
		
		out.println("</form>");
		
		
		cows += 2;
		bulls++;
		
		out.println("</body>"); 
		out.println("</html>");
		
		
		
		
		
		
		
	}
}
