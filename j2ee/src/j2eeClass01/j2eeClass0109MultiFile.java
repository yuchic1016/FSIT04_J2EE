package j2eeClass01;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//多檔上傳
@WebServlet("/j2eeClass0109MultiFile")
@MultipartConfig
public class j2eeClass0109MultiFile extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//處理response
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		//
		String uploadPath = getServletContext().getInitParameter("file-upload");
		System.out.println(uploadPath);
		
		
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			String header = part.getHeader("content-disposition");
			String filename = FileNameAPI.getHeaderFilename(header);
			
			long size = part.getSize();
			pw.write(filename +":"+ size + "<br>");
			try {
				BufferedInputStream bin = 
					new BufferedInputStream(part.getInputStream());
				
				byte[] buf = bin.readAllBytes();
				bin.close();
				
				FileOutputStream fout = 
					new FileOutputStream(new File(uploadPath,filename));
				fout.write(buf);
				fout.flush();
				fout.close();
			}catch(Exception e){
				
			}
		}
		
		pw.flush();
		pw.close();

//		Collection<String> files = part.getHeaderNames();
//		for(String header:files) {
////			System.out.println(header);
//			
//			String value = part.getHeader(header);
//			System.out.println(header +":" +value);
//			
//		}
		
//		Enumeration<String> headers =  request.getHeaderNames();
//		while( headers.hasMoreElements()) {
//			String header = headers.nextElement();
//			System.out.println(header);
//			
//			Enumeration<String> values = request.getHeaders(header);
//			while(values.hasMoreElements()) {
//				System.out.println(values.nextElement());
//			}
//		}
		
		
		
		
		
	}
}
