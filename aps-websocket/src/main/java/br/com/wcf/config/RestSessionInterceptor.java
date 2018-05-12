package br.com.wcf.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.messages.DefaultRestMessage.DefaultRestMessageStatus;

@Configuration
public class RestSessionInterceptor extends HandlerInterceptorAdapter implements WebMvcConfigurer {

	@Autowired
	private UsersSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getRequestURI().equals("/api/login")) {
			return super.preHandle(request, response, handler);
		}

		String auth = request.getHeader("authorization");
		if (this.session.get(auth) != null) {
			return super.preHandle(request, response, handler);
		}

		response.getWriter().write(
				new ObjectMapper().writeValueAsString(new DefaultRestMessage(DefaultRestMessageStatus.UNAUTHORIZED)));
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		return false;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
