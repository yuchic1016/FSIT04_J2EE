package j2eeClass02;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/j2eeClass0208ResponseImg")
public class j2eeClass0208ResponseImg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response 輸出圖形 (利用graphic2D)
		response.setContentType("image/jpeg");
		
		String rate = request.getParameter("rate");
		float floatrate = Float.parseFloat(rate);
		
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bimg.createGraphics();
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0,0,400,20);
		
		g2d.setColor(Color.RED);
		g2d.fillRect(0,0,(int)(400*floatrate/100),20);
		
		
		g2d.setFont(new Font("Airal",Font.BOLD,36));
		g2d.setColor(Color.GREEN);
		
		g2d.drawString("資策會test", 100, 200);
		
//		
//		//畫筆顏色
//		g2d.setColor(Color.BLACK);
//		//畫筆的粗細
//		g2d.setStroke(new BasicStroke(4));
//		g2d.setFont(new Font("Airal",Font.BOLD,36));
////		g2d.drawString("25%", 0, 0);
//		
//		g2d.drawOval(0, 0, 2, 2);
//		
		
		
		OutputStream out = response.getOutputStream();
		
		//結合兩者
		ImageIO.write(bimg, "jpeg", out);
		
		out.flush();
		out.close();
		
		
		
	}

	
}
