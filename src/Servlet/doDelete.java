package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DB;
import Model.NhanVien;

@WebServlet("/doDelete")
public class doDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		DB db = (DB) session.getAttribute("database");
		NhanVien nv = db.searchNVById(id);
		if (nv.getType() != 1) {
			db.deleteNVById(id);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doList");
			dispatcher.forward(request, response);
		} else {
			session.setAttribute("errDelete", "User is maneger");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doList");
			dispatcher.forward(request, response);
		}
	}

}
