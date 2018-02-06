package j2eeClass02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//浮水印
@WebServlet("/j2eeClass0209img")
public class j2eeClass0209img extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response 輸出圖形 (利用graphic2D)
		response.setContentType("image/jpeg");
		String uploadPath = getServletContext().getInitParameter("file-upload");
		
		BufferedImage bimg =ImageIO.read(new File(uploadPath,"coffee.jpg"));
		Graphics2D g2d = bimg.createGraphics();
		
		Font font = new Font("Airal",Font.BOLD,36);
		
		//變形
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(45),100,0);
		Font newFont = font.deriveFont(tran);
		
		
		g2d.setFont(newFont);
		g2d.setColor(Color.GREEN);
		g2d.drawString("資策會test", 100, 200);
		
		OutputStream out = response.getOutputStream();
		File fileout = new File(uploadPath,"coffee1.jpg");
		//結合兩者
		ImageIO.write(bimg, "jpeg", out);
		ImageIO.write(bimg, "jpeg", fileout);
		
		out.flush();
		out.close();
		
	}

	

}
