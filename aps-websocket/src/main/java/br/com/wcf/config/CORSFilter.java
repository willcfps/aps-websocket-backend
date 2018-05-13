package br.com.wcf.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse map = (HttpServletResponse) response;
		map.addHeader("Access-Control-Allow-Origin", rq.getHeader("origin"));
		map.addHeader("Access-Control-Allow-Headers",
				"origin, content-type, accept, user, authorization, X-Requested-With");
		map.addHeader("Access-Control-Allow-Credentials", "true");
		map.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		map.addHeader("Access-Control-Max-Age", "1209600");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
