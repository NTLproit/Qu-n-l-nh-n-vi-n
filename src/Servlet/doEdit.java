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

@WebServlet("/doEdit")
public class doEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doEdit() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		DB db = new DB();
		NhanVien nv = db.searchNVById(id);
		session.setAttribute("nvedit", nv);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("editName");
		int age = Integer.parseInt(request.getParameter("editAge"));
		String address = request.getParameter("editAddress");
		String position = request.getParameter("editPosition");
		String desciption = request.getParameter("editDescription");
		String username = request.getParameter("editUsername");
		String password = request.getParameter("editPassword");
		int type = Integer.parseInt(request.getParameter("editType"));
		
		NhanVien nv = new NhanVien(id, name, age, address, position, desciption, username, password, type);
		DB db = (DB) session.getAttribute("database");
		if (db.updateNV(nv)) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doList");
			dispatcher.forward(request, response);
		}
	}

}
