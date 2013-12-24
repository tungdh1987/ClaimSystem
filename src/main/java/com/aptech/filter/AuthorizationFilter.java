package com.aptech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {

	static final String LOGIN_PAGE = "/account/login";

	private FilterConfig filterConfig = null;

	@Override
	public void destroy() {
		this.filterConfig = null;

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {

		if (this.filterConfig == null)
			return;

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();

		if (!request.getRequestURI().startsWith("/resources")) {

			if (session.getAttribute("user") == null
					&& !LOGIN_PAGE.equals(request.getRequestURI())) {
				String prevUrl = request.getRequestURL().toString();
				String query = request.getQueryString();

				prevUrl = (query == null) ? prevUrl : prevUrl + "?" + query;

				session.setAttribute("prevUrl", prevUrl);
				response.sendRedirect("/account/login");
			}
		}
		filterChain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}

}
