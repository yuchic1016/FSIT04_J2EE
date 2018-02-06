package j2eeClass02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//分支分流
@WebServlet("/j2eeClass0202")
public class j2eeClass0202 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher
				("j2eeClass0202TEST1?name=ok");
//		RequestDispatcher dispatcher2 = request.getRequestDispatcher("j2eeClass0202TEST2");
		RequestDispatcher dispatcher3 = request.getRequestDispatcher("j2eeClass0202TEST3.html");

//		out.write();
		//另種寫法
		out.println("<h1>Big Company</h1>");
		out.println("<hr/>");
		
		dispatcher1.include(request, response);
//		dispatcher2.include(request, response);
		dispatcher3.include(request, response);
		out.println("<hr/>");
		
	}

	

}
