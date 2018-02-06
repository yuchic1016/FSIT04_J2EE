package j2eeClass01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此anotation 決定網址 
@WebServlet("/j2eeClass0101Response")
public class j2eeClass0101Response extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	
	private int i;
    public j2eeClass0101Response() {
        super();
        System.out.println("j2eeClass0101()");
        
    }

    //網頁reload只會執行doGet or .., 並不會產生第二個物件實體 所以建構子只會執行一次 所以大多不寫 除非要做某些初始化
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		pw.append("Served at: ");
		pw.append("Hello.." + i++);
		pw.flush();
		System.out.println("OK");
		System.out.println(response.getHeaderNames());
		System.out.println(response.getHeader("Date"));
		System.out.println(response.getHeaders("Date"));
		System.out.println(response.getContentType());
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}

}
