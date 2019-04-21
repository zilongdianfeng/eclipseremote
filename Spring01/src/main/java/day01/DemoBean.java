package day01;

import java.io.PrintWriter;
import java.io.Serializable;
//bbb+aaa
public class DemoBean implements Serializable{

	private PrintWriter out;
	public void init(){
		//鍒濆鍖栬祫婧�
		try {
			out = new PrintWriter("demo.txt");
			//鎴戝湪杩欏効淇敼杩�
			System.out.println("鎵撳紑鏂囦欢demo.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		//鍏抽棴璧勬簮
		out.flush();
		out.close();
		System.out.println("demo.txt鏂囦欢琚叧闂簡");
	}
	
	public void print(String str){
		out.println(str);
	}
	
}
