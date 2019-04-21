package day01;

import java.io.PrintWriter;
import java.io.Serializable;

public class DemoBean implements Serializable{

	private PrintWriter out;
	public void init(){
		//��ʼ����Դ
		try {
			out = new PrintWriter("demo.txt");
			System.out.println("���ļ�demo.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		//�ر���Դ
		out.flush();
		out.close();
		System.out.println("demo.txt�ļ����ر���");
	}
	
	public void print(String str){
		out.println(str);
	}
	
}
