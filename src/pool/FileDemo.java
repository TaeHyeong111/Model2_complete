package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\hb1002\\Documents\\sample.txt";
		
		try {
			File file = new File(PATH);
			FileWriter fw = new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[메뉴] 1.전송 2.읽기 0.종료");
				switch(s.next()) {
				case "1" : 
					System.out.println("메세지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();
					break;
				case "2" :
					System.out.println("메세지 보기");
					String msg = reader.readLine();
					while((msg = reader.readLine())!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0" :
					break;
				default: 
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FileName fn = new FileName(PATH);
		System.out.println("파일명 : "+fn.getFilename());
		System.out.println("확장자 : "+fn.getExt());
	}
}
// inner class는 public을 갖지 않는다.
	// 이유는 이 클래스 내부에서만 사용하고자 함이다.
	// 만약 다른 곳에서 계쏙 사용한다면 독립시켜야한다.
	// 1회용 사용 클래스라고 생각하면 된다.

class FileName {
	private String path,sep,ext,filename;
	public FileName(String path) {
		this.path = path;
		this.sep = File.separator;
		//"C:\\Users\\hb1002\\Documents\\sample.txt";
		this.ext = path.substring(path.lastIndexOf(".")+1);
		this.filename = path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf("."));
		System.out.println(ext);
		System.out.println(filename);
		//lastIndexOf("\\")+1
		//lastIndexOf(".")
		//subString() 사용해서 해결바람
	}
	private int lastIndexOf(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFilename() {
		return filename;
	}
}
	

// 확장자 exe, java, xls, ...
// 파일명을 넣으면 확장자를 분해하길 위해 메소드만듦
