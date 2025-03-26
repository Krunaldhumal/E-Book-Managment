package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.connection.DBConnection;

/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/deletedata")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteData() {
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
			PreparedStatement prstm = con.prepareStatement("DELETE FROM demo.book where bookid = ?;");
			prstm.setInt(1, id);
			Integer value = prstm.executeUpdate();
			PrintWriter out = response.getWriter();

			if (value == 1) {
				out.print("<html><body>");
				out.append("<center style = \"color:red;\"><h2>" + value + "Book Deleted</h2></center>");
				out.print("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/showbookdata");
				rd.include(request, response);
			} else {
				out.print("<html><body>");
				out.append("<center style = \"color:red;\">No Book Deleted</center>");
				out.print("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/showbookdata");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
