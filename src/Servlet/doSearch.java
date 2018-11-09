package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DB;
import Model.NhanVien;

@WebServlet("/doSearch")
public class doSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doSearch() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/search.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = request.getParameter("searchName");
		DB db = (DB) session.getAttribute("database");
		ArrayList<NhanVien> listNVSearch = db.searchNVByName(name);
		session.setAttribute("listNVSearch", listNVSearch);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listNVSearch.jsp");
		dispatcher.forward(request, response);
	}

}
