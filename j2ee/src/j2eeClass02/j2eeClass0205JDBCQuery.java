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


@WebServlet("/j2eeClass0205JDBCQuery")
public class j2eeClass0205JDBCQuery extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii","root","root");
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM member";
			ResultSet rs =stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String account = rs.getString("account");
				String passwd = rs.getString("password");
				String realname = rs.getString("realname");
				out.println(id+":"+realname+"<br>");
			}
			
			out.flush();
			stmt.close();
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	

}
