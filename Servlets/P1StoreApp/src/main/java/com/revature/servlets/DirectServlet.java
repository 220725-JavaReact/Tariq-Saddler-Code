package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.DAO;
import com.revature.dl.wordDAO;
import com.revature.models.*;

public class DirectServlet extends HttpServlet{
	int newInt = 0;
	
	private static DAO<word> wordDao = new wordDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		String newWord = req.getParameter("Word");
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		boolean isHeterogram = true;
		
		
		//level
		for(int i = 0; i<newWord.length(); i++)
		{
			for(int x = i+1; x<newWord.length(); x++)
			{
				if(newWord.charAt(i) == newWord.charAt(x))
				{
					isHeterogram = false;
					break;
				}
			}
			if(!isHeterogram)
			{
				break;
			}
		}
		
		if(isHeterogram)
		{
			word brandNewWord = new word(newWord.length(), newWord);
			wordDao.addInstance(brandNewWord);
			System.out.println("Direct get");
			res.setContentType("text/html");
			//res.getWriter().write("<html><body><h1>The Servlet is talking directly to the client</h1></body</html>");
			res.getWriter().write("<body><h1>The word " + newWord + " WAS SUCCESSFULLY ADDED TO THE DATABASE!</h1></body>");
			
			out.println("<form method = \"get\" action = \"/P1StoreApp/play\">");
			
			out.println("<input type = \"submit\" value = \"PLAY GAME\">");
			
			out.println("</form>");
			
			out.println("<form method = \"get\" action = \"/P1StoreApp/direct\">");
			
			out.println("<p>Input another heterogram (a word with no repeating letters) to the database</p>");
			
			out.println("<input type = \"text\" minlength = 2 maxlength = 6 name = \"Word\" required><br>");
			
			out.println("<input type = \"submit\" value = \"SUBMIT\">");
			
			out.println("</form>");
			
		}
		else
		{
			res.setContentType("text/html");
			res.getWriter().write("<body><h1>The word " + newWord + " is NOT a heterogram!</h1></body>");
			out.println("<h1>Remember, a heterogram is a word with NO repeating letters! </h1><br>");
			
			out.println("<form method = \"get\" action = \"/P1StoreApp/play\">");
			
			out.println("<input type = \"submit\" value = \"PLAY GAME\">");
			
			out.println("</form>");
			
			out.println("<form method = \"get\" action = \"/P1StoreApp/direct\">");
			out.println("<p>Input another heterogram to the database</p>");
			out.println("<input type = \"text\" minlength = 2 maxlength = 6 name = \"Word\" required><br>");
			out.println("<input type = \"submit\" value = \"SUBMIT\">");
			
			out.println("</form>");
			
		}
		
		
		
		//res.setContentType("text/html");
     
		
		//res.getWriter().write("<html><body><h1>Your word is " + newWord + "</h1></body</html>");
		
		
		/*<form method = "get" action = "/P1StoreApp/direct">
			<p>Direct Servlet, GET</p>
			<input type = "submit" value = "Direct Text Response"/>
			<input type = "text"/>
		</form>
		*/
	}

}
