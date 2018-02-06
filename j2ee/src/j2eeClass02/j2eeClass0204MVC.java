package j2eeClass02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0204MVC")
public class j2eeClass0204MVC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//0.prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if(x==null) { x="0"; }
		if(y==null) { y="0"; }
		
		//1.Model
		CModel model = new CModel(x,y);
		int result = model.add();
		
		//2.view (利用dispatch)
		RequestDispatcher dispatcher = request.getRequestDispatcher("j2eeClass0204Dispatch?result=" + result);
//		dispatcher.include(request, response);
		dispatcher.forward(request, response);
		
	}

}
