package in.employee.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(1) 
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;

		HttpServletResponse httpResp = (HttpServletResponse) response;

		System.out.println("Request In Authentication");

		String token = httpReq.getHeader("token");
		String apiKey = httpReq.getHeader("api-key");

		if (token == null || !token.equals("hransari143")) {
			httpResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResp.setContentType("application/json");
			httpResp.getWriter().write("{\r\n"
					+ "  \"message\" : \"Authentication is Required\"\r\n"
					+ "}");
			return; 
		}
		if (apiKey == null || !apiKey.equals("hransari143")) {
			httpResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

			httpResp.setContentType("application/json");
			httpResp.getWriter().write("{\r\n" 
					+ "  \"message\" : \"Invalid User\"\r\n"
					+ "}");

			return;
		}
		chain.doFilter(request, response);
	}

}
