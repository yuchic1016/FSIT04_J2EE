package j2eeClass02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0203Forward")
public class j2eeClass0203Forward extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher
				("j2eeClass0203Dispath");

		out.println("0203Forward");
		
		//重新導向到另一支
//		dispatcher.forward(request, response);
		String name = request.getParameter("name");
		if(name == null) {
			dispatcher.forward(request, response);
		}else {
			out.println("welcome 1");
		}
		
		
		
		
	}

	

}
