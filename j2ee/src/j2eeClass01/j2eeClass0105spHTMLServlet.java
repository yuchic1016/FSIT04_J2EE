package j2eeClass01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0105spHTMLServlet")
public class j2eeClass0105spHTMLServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//key+value list:
//		Enumeration<String> params = request.getParameterNames();
//		while(params.hasMoreElements()) {
//			String key = params.nextElement();
//			String value = request.getParameter(key);
//			System.out.println(key + ":"+value);
//		}
		
		//處理request
		int x,y,op,result;
		x= y = op = result = 0;
		String opString = "";
		
		try {
			x = Integer.parseInt(request.getParameter("x"));
		 	y = Integer.parseInt(request.getParameter("y"));
			op = Integer.parseInt(request.getParameter("op"));
			
			switch(op){
				case 1: result = x+y; opString="+"; break;
				case 2: result = x-y; opString="-"; break;
				case 3: result = x*y; opString="*"; break;
				case 4: result = x/y; opString="/"; break;
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		//處理response
		response.setContentType("text/html; charset=UTF-8"); //ex:img/jpb
		PrintWriter pw = response.getWriter();
		pw.write(x + opString + y + "=" + result);
		pw.flush();
		pw.close();
	}

}
