package j2eeClass01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0102Request")
public class j2eeClass0102Request extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//認識HttpServletRequest (Request)
		//不同瀏覽器有不同header
		System.out.println(request.getHeaderNames());
		//getHeaderNames() 傳回的是 "列舉"
		Enumeration<String> headerNames =  request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			//key
			String header = headerNames.nextElement();
			System.out.print(header+":");
			
			//value : is-a Enumeration too
			Enumeration<String> values = request.getHeaders(header);
			while(values.hasMoreElements()) {
				String value = values.nextElement();
				System.out.println(value);
			}
		}
		
		System.out.println(request.getAuthType());
		System.out.println(request.getMethod());
		System.out.println(request.getQueryString());
		
		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getServletPath());
		System.out.println("-------------");
		
	}

	
}
