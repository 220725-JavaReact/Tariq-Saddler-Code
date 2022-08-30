package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.DAO;
import com.revature.dl.GuessDAO;
import com.revature.dl.wordDAO;
import com.revature.models.Guess;
import com.revature.models.word;
import java.util.stream.IntStream;


public class PlayServlet extends HttpServlet{
	int bulls = 0;
	int cows = 0;
	public static int tries = 0;
	
	private static DAO<word> wordDao = new wordDAO();
	private static DAO<Guess> guessDao = new GuessDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		word secret_word = null;
		if(wordDao.findSecretWord() == null)
		{
			//System.out.println("IN THE IF STATEMENT");
			wordDao.markSecretWord();

		}
		
		secret_word = wordDao.findSecretWord();
		
		
		String newGuess = req.getParameter("Guess");
		
		if(!Objects.equals(null, newGuess))
		{
			
			//MAKE BULLS AND COWS LOGIC HERE, compare guess to secret_word
//			for(int i = 0; i < newGuess.length(); i++)
//			{
//				if(secret_word.getWordName().toLowerCase().charAt(i) == newGuess.toLowerCase().charAt(i))
//				{
//					bulls++;
//				}
//			}
			cows = 0;
			bulls = 0;
			
			for(int i = 0; i < newGuess.length(); i++)
			{
				for(int x = 0; x<secret_word.getWordName().length(); x++)
				{
					//play (secret word)
					//paly (guess)
					if(secret_word.getWordName().toLowerCase().charAt(x) == newGuess.toLowerCase().charAt(i) && i == x)
					{
						bulls++;
					}
					if(secret_word.getWordName().toLowerCase().charAt(x) == newGuess.toLowerCase().charAt(i) && i != x)
					{
						cows++;
					}
				}
			}
			
		
			
			//If GUESS is the same as secret_word, redirect to WinServlet
			if(newGuess.toLowerCase().equals(secret_word.getWordName().toLowerCase()))
			{
				//Display all guesses (bulls and cows) together with the last one
				res.sendRedirect("http://localhost:8080/P1StoreApp/win");
			}
			
			//
			
			
			Guess brandNewGuess = new Guess(newGuess, bulls, cows);
			guessDao.addInstance(brandNewGuess);
			
		}
			
		
		
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>"); 
        out.println("<title>Input Servlet</title>"); 
        out.println("</head>"); 
        out.println("<body>"); 
        out.println("<h1>GOOD LUCK!</h1>");   
        
		
		
		
		
		//out.println("<h1>THE SECRET WORD IS " + secret_word.getWordName() + "</h1>");
		out.println("<h1>The secret word has " + secret_word.getLength() + " letters!</h1>");
		
		out.println("<h3>The secret word will always be a heterogram!</h3>");  
		
		
		out.println("<label>TRIES___GUESS___</label><label>BULLS___</label><label>COWS___</label>");
		ArrayList<Guess> guesses = guessDao.getAllInstances();
		if(guesses.size() != 0)
		{
			tries++;
			for(Guess thisGuess: guessDao.getAllInstances())
			{
				out.println("<br><label>GUESS: " + thisGuess.getGuessName() + " BULLS: " + thisGuess.getBulls() + " COWS: "+ thisGuess.getCows() +"</label>");
			}
			//tries++;
			out.println("<br><label>TRIES: "+ tries+"</label>");
		}
		
		
		
		
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/play\">");
		out.println("<br><input type = \"text\" maxlength="+ secret_word.getLength() + " minlength=" + secret_word.getLength() + " name = \"Guess\" required size = 5>");
		
		out.println("<input type = \"submit\" value = \"GUESS\">");
	
		out.println("</form>");
		
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/reset\">");
		out.println("<h2>----------------------------------------------------</h2>");
		out.println("<input type = \"submit\" value = \"GIVE UP\">");
		out.println("</form>");
		
		
//		cows += 2;
//		bulls++;
		
		
		out.println("</body>"); 
		out.println("</html>");
		
		
		
		//flag = true;

		
	}
}
