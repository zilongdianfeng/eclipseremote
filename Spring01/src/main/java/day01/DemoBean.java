package day01;

import java.io.PrintWriter;
import java.io.Serializable;
//aaa
public class DemoBean implements Serializable{

	private PrintWriter out;
	public void init(){
		//初始化资源
		try {
			out = new PrintWriter("demo.txt");
			//我在这儿修改过
			System.out.println("打开文件demo.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		//关闭资源
		out.flush();
		out.close();
		System.out.println("demo.txt文件被关闭了");
	}
	
	public void print(String str){
		out.println(str);
	}
	
}
