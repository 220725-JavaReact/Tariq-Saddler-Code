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
	
	private static DAO<Word> wordDao = new wordDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String newWord = req.getParameter("Word");
		Word brandNewWord = new Word(newWord.length(), newWord);
		wordDao.addInstance(brandNewWord);
		
		newInt += 4;
		System.out.println("Direct get");
		res.setContentType("text/html");
		res.getWriter().write("<html><body><h1>The Servlet is talking directly to the client</h1></body</html>");
		res.getWriter().write("<html><body><h1>The WORD: " + newWord + " The INT: " + newInt + "</h1></body</html>");
		res.getWriter().write("<html><body>"
				+ "<form method = \"get\" action = \"/P1StoreApp/direct\">"
					+ "<input type = \"submit\" value = \"Direct Text Response\"/>"
					+ "</form>"
				+ "</body></html>");
		
		
		//res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>"); 
        out.println("<head>"); 
        out.println("<title>Input Servlet</title>"); 
        out.println("</head>"); 
        out.println("<body>"); 
        out.println("<h1>"); 
        out.println("Hello " + newWord); 
        out.println("</h1>"); 
        out.println("</body>"); 
        out.println("</html>"); 
		
		//res.getWriter().write("<html><body><h1>Your word is " + newWord + "</h1></body</html>");
		
		if(newInt > 100)
		{
			res.getWriter().write("<html><body><h1>The Servlet is talking directly to the client</h1></body</html>");
			newInt = 0;
		}
		
		/*<form method = "get" action = "/P1StoreApp/direct">
			<p>Direct Servlet, GET</p>
			<input type = "submit" value = "Direct Text Response"/>
			<input type = "text"/>
		</form>
		*/
	}

}

