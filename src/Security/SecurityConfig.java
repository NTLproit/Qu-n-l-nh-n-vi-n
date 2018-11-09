package Security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
	private static final List<String> listCss = new ArrayList<>();

	static {
		init();
	}

	private static void init() {
		// vai tro cua Employee
		List<String> urlPatterns1 = new ArrayList<String>();
		urlPatterns1.add("/doSearch");
		urlPatterns1.add("/doList");
		urlPatterns1.add("/doLogout");
		urlPatterns1.add("/doHome");
		urlPatterns1.add("/doManegement");
		mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);

		List<String> urlPatterns2 = new ArrayList<String>();
		urlPatterns2.add("/doEdit");
		urlPatterns2.add("/doDelete");
		urlPatterns2.add("/doAdd");
		urlPatterns2.add("/doSearch");
		urlPatterns2.add("/doList");
		urlPatterns2.add("/doLogout");
		urlPatterns2.add("/doHome");
		urlPatterns2.add("/doManegement");
		mapConfig.put(ROLE_MANAGER, urlPatterns2);

		listCss.add("css");
		listCss.add("image");
		listCss.add("js");

	}

	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}

	public static List<String> getlistCss() {
		return listCss;
	}
}
