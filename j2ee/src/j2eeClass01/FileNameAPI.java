package j2eeClass01;

public class FileNameAPI {
	public static String getHeaderFilename(String header) {
		//取C:\Users\\user\Pictures\ball.png
//		System.out.println(header);
		int start = header.lastIndexOf("filename");
		String temp = header.substring(start+10);
		String filename = temp.substring(0, temp.lastIndexOf('"'));
		
		int s1 = filename.lastIndexOf("\\");
		
		String retFile = null;
		
		if (s1 >=0 ) {
			retFile = filename.substring(s1+1);
		}else {  //Google 的只有檔名 直接傳回
			retFile = filename;
		}
		
		
		
		
		return retFile;
	}
}
