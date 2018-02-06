package j2eeClass02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0204Dispatch")
public class j2eeClass0204Dispatch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String result = request.getParameter("result");
//		out.println(x+"+"+y+"="+result);
		
		try {
			String html = loadView("j2eeClass0204Cal.html");
			String outhtml = String.format(html, x,y,result);
			out.println(outhtml);
		} catch (Exception e) {
			out.println("Server Busy");
		}
		
		
		
	}

	private String loadView(String file) throws Exception{
		String templatedPath = getServletContext().getInitParameter("template-path");
		
		File viewFile = new File(templatedPath,file);
		byte[] buf = new byte[(int)viewFile.length()];
		BufferedReader br = new BufferedReader(new FileReader(viewFile));
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		
		return sb.toString();
		
	}

}
