package j2eeClass01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//本範例只在 了解servlet 嵌入html (一般不會這樣寫 ,會用mvc架構)
@WebServlet("/j2eeClass0106spOnlyServlet")
public class j2eeClass0106spOnlyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//處理request
		String xStr,yStr,resultStr;
		int op;
		try {
			int x = Integer.parseInt(request.getParameter("x"));
		 	int y = Integer.parseInt(request.getParameter("y"));
			op = Integer.parseInt(request.getParameter("op"));
			int result = 0;
			switch(op){
				case 1: result = x+y; break;
				case 2: result = x-y; break;
				case 3: result = x*y; break;
				case 4: result = x/y; break;
			}
			xStr = ""+x ;
			yStr = ""+y ;
			resultStr = ""+result ;
			
		}catch(Exception e){
			xStr = yStr = resultStr = "";
			op = 1;
		}
		
		//處理response (直接把前端html寫在這 , 就不另寫一支.html)
		response.setContentType("text/html; charset=UTF-8"); //ex:img/jpb
		PrintWriter pw = response.getWriter();
		pw.append("<form>")
			.append("<input type='text' name='x' value='"+xStr+"'/> \n")
			.append("<select name='op'>")
			.append("<option value='1'"+(op==1?"selected":"")+">+</option>")
			.append("<option value='2'"+(op==2?"selected":"")+">-</option>")
			.append("<option value='3'"+(op==3?"selected":"")+">*</option>")
			.append("<option value='4'"+(op==4?"selected":"")+">/</option>")
			.append("</select> \n")
			.append("<input type='text' name='y' value='"+yStr+"'/> \n")
			.append("<input type='submit' value='='/> \n")
			.append(resultStr)
			.append("</form>");

	}


}
