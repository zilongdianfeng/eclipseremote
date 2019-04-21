package day01;

import java.io.Serializable;

public class HelloWorld implements Serializable{

	private static final long serialVersionUID = -6369260196794628789L;
	private String messae = "Hello World";
	public HelloWorld(){
		
	}
	public String getMessae() {
		return messae;
	}
	public void setMessae(String messae) {
		this.messae = messae;
	}
	
	public String say() {
		return "HelloWorld";
	}
	@Override
	public String toString() {
		return "HelloWorld [messae=" + messae + "]";
	}
	
}
