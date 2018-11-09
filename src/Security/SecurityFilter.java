package Security;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.NhanVien;


/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String servletPath = request.getServletPath();
		NhanVien loginedUser = (NhanVien) request.getSession().getAttribute("loginedUser");
		if (SecurityUtils.hasCSS(request)) {
			//lay css
			chain.doFilter(request, response);
			return;
		} else {

			if (loginedUser == null) {
				if (servletPath.equals("/doLogin")) {
					chain.doFilter(request, response);
					return;
				} else {
					// no user logined va danh lung tung chuyen trang mac dinh

					RequestDispatcher dispatcher //
							= request.getServletContext().getRequestDispatcher("/doLogin");

					dispatcher.forward(request, response);
					return;
				}
			} else if (loginedUser != null) {
				// User Name
				String userName = loginedUser.getUsername();

				if (SecurityUtils.isSecurityPage(request)) {

					if (SecurityUtils.hasPermission(request)) {
						//co quyen
						chain.doFilter(request, response);
						return;
					} else {
						//khong co quyen

						RequestDispatcher dispatcher //
								= request.getServletContext().getRequestDispatcher("/accessDeniedView.jsp");

						dispatcher.forward(request, response);
						return;
					}

				} else {
					//trang khong phai login
					RequestDispatcher dispatcher //
							= request.getServletContext().getRequestDispatcher("/doHome");

					dispatcher.forward(request, response);
					return;
				}

			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
