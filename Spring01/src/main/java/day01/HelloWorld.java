package day01;

import java.io.Serializable;

public class HelloWorld implements Serializable{

	private String messae = "Hello World";
	public HelloWorld(){
		
	}
	public String getMessae() {
		return messae;
	}
	public void setMessae(String messae) {
		this.messae = messae;
	}
	@Override
	public String toString() {
		return "HelloWorld [messae=" + messae + "]";
	}
	
}
