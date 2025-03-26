package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addservlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.append("<html lang=\"en\">\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "<title>Book Management System</title>\r\n" + "<link\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\">\r\n" + "<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\"\r\n"
				+ "	integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\"\r\n"
				+ "	crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "<div class=\"container mt-5\">\r\n" + "<h1>Book Management System</h1>\r\n"
				+ "	<form action=\"addservlet\" method=\"post\">\r\n" + "<div class=\"form-group\">\r\n"
				+ "	<label for=\"title\">Title:</label> <input type=\"text\"\r\n"
				+ "	class=\"form-control\" id=\"title\" name=\"title\">\r\n" + "</div>\r\n"
				+ "	<div class=\"form-group\">\r\n" + "	<label for=\"author\">Author:</label> <input type=\"text\"\r\n"
				+ "	class=\"form-control\" id=\"author\" name=\"author\">\r\n" + "</div>\r\n"
				+ "	<button type=\"submit\" class=\"btn btn-primary ml-3\">Add Book</button>\r\n"
				+ "	<a href=\"/BookManagmentProject/showbookdata\">\r\n"
				+ "	<button type=\"button\" class=\"btn btn-primary\">View Book</button>\r\n" + "	</a>\r\n"
				+ "</form>\r\n" + "\r\n" + "	</div>\r\n" + "</body>\r\n" + "</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		PrintWriter out = response.getWriter();

		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement("insert into demo.book (bookname, bookauthor) values (?, ?)");
			ps.setString(1, title);
			ps.setString(2, author);

			int value = ps.executeUpdate();

			if (value > 0) {
				out.print("<html><body>");
				out.append("<center style = \"color:blue;\">New Book Added</center>");
				out.print("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			} else {
				out.print("<html><body>");
				out.append("<center style = \"color:red;\">Your book is not added. please re-enter.</center>");
				out.print("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
