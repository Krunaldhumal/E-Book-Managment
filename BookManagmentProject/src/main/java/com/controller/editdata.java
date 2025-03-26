package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;

/**
 * Servlet implementation class editdata
 */
@WebServlet("/editdata")
public class editdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editdata() {
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
		try {
			Connection con = new DBConnection().getConnection();
			Integer id = Integer.parseInt(request.getParameter("id"));
			PreparedStatement prstm = con.prepareStatement("SELECT * FROM demo.book where bookid = ?;");
			prstm.setInt(1, id);
			ResultSet rs = prstm.executeQuery();
			if (rs.next()) {
				PrintWriter out = response.getWriter();
				out.append("<html lang=\"en\">\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "<title>Book Management System</title>\r\n" + "<link\r\n"
						+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n"
						+ "	rel=\"stylesheet\">\r\n" + "</head>\r\n" + "<body>\r\n"
						+ "	<div class=\"container mt-5\">\r\n" + "		<h1>Edit Book Data</h1>\r\n"
						+ "		<form action=\"editdata\" method=\"post\">\r\n"
						+ "			<div class=\"form-group\">\r\n" + "<input type=\"hidden\"\r\n value = "
						+ rs.getInt(1) + " name=\"id\">\r\n"
						+ "				<label for=\"title\">Title:</label> <input type=\"text\"\r\n"
						+ "					class=\"form-control\" id=\"title\" value = " + rs.getString(2)
						+ " name=\"title\">\r\n" + "</div>\r\n" + "<div class=\"form-group\">\r\n"
						+ "				<label for=\"author\">Author:</label> <input type=\"text\"\r\n"
						+ "					class=\"form-control\" id=\"author\" value = " + rs.getString(3)
						+ " name=\"author\">\r\n" + "			</div>\r\n"
						+ "			<button type=\"submit\" class=\"btn btn-primary ml-3\">Edit Book</button>\r\n"
						+ "		</form>\r\n" + "		\r\n" + "	</div>\r\n" + "</body>\r\n" + "</html>");
			} else {
				System.out.println("get else");
				RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.include(request, response);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titel = request.getParameter("title");
		String author = request.getParameter("author");
		Integer id = Integer.parseInt(request.getParameter("id"));
	
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement prstm = con
					.prepareStatement("UPDATE demo.book set bookname = ?, bookauthor = ? where bookid = ?;");
			prstm.setString(1, titel);
			prstm.setString(2, author);
			prstm.setInt(3, id);
			System.out.println(titel);
			System.out.println(author);
			System.out.println(id);
			Integer value = prstm.executeUpdate();
			PrintWriter out = response.getWriter();
			if (value == 1) {
				out.print("<html><body>");
				out.append("<center style = \"color:green;\"><h2>" + value + " Book Data Updated</h2></center>");
				out.print("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/showbookdata");
				rd.include(request, response);
			} else {
				System.out.println("post else");

				out.print("<html><body>");
				out.append("<center style = \"color:red;\">No Book Data Updated</center>");
				out.print("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/showbookdata");
				rd.include(request, response);

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
