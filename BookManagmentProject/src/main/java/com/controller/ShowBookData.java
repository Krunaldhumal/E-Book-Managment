package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;

import com.connection.DBConnection;
import com.data.Data;

/**
 * Servlet implementation class ShowBookData
 */
@WebServlet("/showbookdata")
public class ShowBookData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowBookData() {
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
			PreparedStatement prstm = con.prepareStatement("SELECT * FROM demo.book;");
			ResultSet rs = prstm.executeQuery();
			PrintWriter out = response.getWriter();

			out.append("<html lang=\"en\">\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "<title>Book Management System</title>\r\n" + "<link\r\n"
					+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n"
					+ "	rel=\"stylesheet\">\r\n" + "</head>\r\n" + "<body>\r\n" + "<h2>Books</h2>\r\n"
					+ "		<table class=\"table\">\r\n");
			out.println("<tr>\r\n" + "<th>No.</th>\r\n" + "<th>Title</th>\r\n" + "<th>Author</th>\r\n"
					+ "	<th>Delet</th><th>Edit Book</th>\r\n" + "</tr>");

			while (rs.next()) {
				Data db = new Data(rs.getInt(1), rs.getString(2), rs.getString(3));
				out.append("<tr><td>" + db.getid() + "</td><td>" + db.getBookname() + "</td><td>" + db.getBookauthor()
						+ "</td>" + "<td><a href=\"/BookManagmentProject/deletedata?id=" + db.getid()
						+ "\">Delete</a></td>" + "<td><a href=\"/BookManagmentProject/editdata?id=" + db.getid()
						+ "\">Edit</a></td></tr>");

//				HttpSession session = request.getSession();
//				session.setAttribute("id", rs.getInt(1));

			}
			out.println("</table>\r\n");
			out.append("<a href=\"index.jsp\" style=\"width: 100%;\">\r\n"
					+ "	<button type=\"button\" class=\"btn btn-info ml-3\"\">Home</button>\r\n"
					+ "	</a>\r\n </center>");
			out.println("</body>\r\n" + "</html>");

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
