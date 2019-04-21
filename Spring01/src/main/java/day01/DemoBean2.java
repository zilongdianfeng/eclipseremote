package day01;

import java.io.PrintWriter;

public class DemoBean2 {
	private PrintWriter out;
	public void init(){
		//初始化资源
		try {
			out = new PrintWriter("demo2.txt");
			System.out.println("打开文件demo2.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		//关闭资源
		out.flush();
		out.close();
		System.out.println("demo2.txt文件被关闭了");
	}
	
	public void print(String str){
		out.println(str);
	}
	
}
