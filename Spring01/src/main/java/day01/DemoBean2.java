package day01;

import java.io.PrintWriter;

public class DemoBean2 {
	private PrintWriter out;
	public void init(){
		//��ʼ����Դ
		try {
			out = new PrintWriter("demo2.txt");
			System.out.println("���ļ�demo2.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		//�ر���Դ
		out.flush();
		out.close();
		System.out.println("demo2.txt�ļ����ر���");
	}
	
	public void print(String str){
		out.println(str);
	}
	
}
