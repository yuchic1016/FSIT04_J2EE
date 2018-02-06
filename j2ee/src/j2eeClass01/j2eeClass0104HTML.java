package j2eeClass01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0104HTML")
public class j2eeClass0104HTML extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		System.out.println("doGet()");
		doTask(request,response,"doGet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doTask(request,response,"doPost");
	}
	
	private void doTask(HttpServletRequest request, HttpServletResponse response,String act) 
			throws ServletException, IOException {
		//response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write("hello,你好 :" + act + "<br>");
		
		//request
//		request.setCharacterEncoding("UTF-8");
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()) {
			String key = params.nextElement();
			String value = request.getParameter(key);
			//處理request UTF8
			String nvalue = new String(value.getBytes("ISO-8859-1"),"UTF-8");
			pw.write(key +":"+nvalue + "<br>");
		}

		pw.flush();
		pw.close();
	}
	

}
