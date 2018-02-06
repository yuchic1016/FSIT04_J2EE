package j2eeClass02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0206Crypt")
public class j2eeClass0206Crypt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//產生密碼編碼
		String passwd = "123456";
		String salt = BCrypt.gensalt();
		String npasswd = BCrypt.hashpw(passwd, salt);
		out.println(npasswd);
		
		//密碼解碼
		if(API.ckPasswd("123456",npasswd)) {
			out.println("OK");
		}else {
			out.println("XX");
		}
		
	}

	

}
