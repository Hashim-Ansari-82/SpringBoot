package in.employee.filter;

import java.io.IOException;
import java.util.UUID;

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
@Order(2)
public class LogingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq=(HttpServletRequest) request;
		HttpServletResponse httpResp=(HttpServletResponse) response;
		
		long startTime=System.currentTimeMillis();
		
		String reqId=UUID.randomUUID().toString();
		
		httpResp.setHeader("X-Request-ID" , reqId); 
		
		System.out.println("Incoming Request "
		+httpReq.getMethod()+"  "
        +httpReq.getRequestURI());
	
		try {
		chain.doFilter(request, response);
		}
		
		finally {
		long duration=System.currentTimeMillis()-startTime;
		
		System.out.println("Outgoing Response " 
		+httpResp.getStatus());
		
		System.out.println("Duration time "+duration);
		}
	}

}
