package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DB;
import Model.NhanVien;

@WebServlet("/doAdd")
public class doAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doAdd() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String name = request.getParameter("addName");
		int age = Integer.parseInt(request.getParameter("addAge"));
		String address = request.getParameter("addAddress");
		String position = request.getParameter("addPosition");
		String desciption = request.getParameter("addDescription");
		String username = request.getParameter("addUsername");
		String password = request.getParameter("addPassword");
		int type = Integer.parseInt(request.getParameter("addType"));
		
		NhanVien nv = new NhanVien(name, age, address, position, desciption, username, password, type);
		DB db = (DB) session.getAttribute("database");
		if (db.checkUsername(username)) {
			if (db.addNV(nv)) {
				session.setAttribute("sucess", "add sucess");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			session.setAttribute("err", "username error");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add.jsp");
			dispatcher.forward(request, response);
		}
	}

}
