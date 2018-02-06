package j2eeClass01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/j2eeClass0107spHTMLServlet2")
public class j2eeClass0107spHTMLServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//request
		String gender = request.getParameter("gender");
		System.out.println(gender);
		
		//checkbox : 利用  String陣列 取值  request.getParameterValues
		String[] hobby = request.getParameterValues("hobby");
		for(String h:hobby) {
			System.out.println(h);
		}
		
	}

	
}
