package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.DAO;
import com.revature.dl.wordDAO;
import com.revature.models.Word;

public class PlayServlet extends HttpServlet{
	
	
	private static DAO<Word> wordDao = new wordDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		res.getWriter().write("<html><body><h1>THIS IS THE PLAY PAGE</h1></body</html>");
		
		
		Word secret_word = null;
		if(wordDao.findSecretWord() == null)
		{
			wordDao.markSecretWord();
			secret_word = wordDao.findSecretWord();
			
		}
		
		
		res.getWriter().write("<html><body><h1>THE SECRET WORD IS " + secret_word.getWordName() + "</h1></body</html>");
		
	}
}

