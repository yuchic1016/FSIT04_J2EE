package j2eeClass02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j2eeClass0207CheckPSW")
public class j2eeClass0207CheckPSW extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii","root","root");
				
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM member WHERE account = '"+account+"'";
			ResultSet rs =stmt.executeQuery(sql);
			
			if(rs.next()) {
				String hPasswd = rs.getString("password");
				if(API.ckPasswd("123456",hPasswd)) {
					out.println("Login Success");
				}else {
					out.println("Login Failure");
				}
			}else {
				//no data
			}
			
		}catch(Exception e) {
			
		}
	}

	

}
