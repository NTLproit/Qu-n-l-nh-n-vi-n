package Security;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import Model.NhanVien;

public class SecurityUtils {
	// kiem tra request co phai dang nhap khong?
	public static boolean isSecurityPage(HttpServletRequest request) {
		String urlPattern = UrlPatternUtils.getUrlPattern(request);

		Set<String> roles = SecurityConfig.getAllAppRoles();

		for (String role : roles) {
			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}

	// Kiem tra 'request' nay co vai tro phu hop hay khong?
	public static boolean hasPermission(HttpServletRequest request) {
		String urlPattern = UrlPatternUtils.getUrlPattern(request);
		try {

			// lay ra usered neu role ==1
			String servletPath = request.getServletPath();
			NhanVien loginedUser = (NhanVien) request.getSession().getAttribute("loginedUser");
			int role = loginedUser.getType();
			String strRole = null;
			if (role == 1) {
				strRole = SecurityConfig.ROLE_MANAGER;

			} else {
				strRole = SecurityConfig.ROLE_EMPLOYEE;
			}
			List<String> list = SecurityConfig.getUrlPatternsForRole(strRole);

			if (list.contains(servletPath)) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("ERROR  AT hasPermission");
		}

		return false;
	}

	public static boolean hasCSS(HttpServletRequest request) {

		try {

			// lay ra usered neu role ==1
			String servletPath = request.getServletPath();
			String ar[] = servletPath.split("/");
			String url = ar[1];

			List<String> list = SecurityConfig.getlistCss();

			if (list.contains(url)) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("ERROR  AT hasPermission");
		}

		return false;
	}
}
