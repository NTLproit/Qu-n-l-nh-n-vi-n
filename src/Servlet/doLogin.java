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

@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DB db = new DB();
		session.setAttribute("database", db);
		NhanVien nv = db.checkUser(username, password);
		if (nv != null) {
			session.setAttribute("loginedUser", nv);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doHome");
			dispatcher.forward(request, response);

		} else {
			session.setAttribute("errLogin", "Login error");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		}
	}

}
