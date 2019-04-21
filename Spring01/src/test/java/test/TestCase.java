package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day01.DemoBean;
import day01.DemoBean2;
import day01.HelloWorld;

public class TestCase {
	private ClassPathXmlApplicationContext ctx;
	@Before
	public void initCtx(){
		//��ʼ��Spring,��Ҫ�ṩ�����ļ�
		//�����ļ�Ĭ��λ��Ϊ resources
		 ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@After//�ڲ��԰���֮��ִ��
	public void destroy(){
		ctx.close();//�ر�Spring������������Bean����
	}
	@Test
	public void testHelloWorld(){
		//��ʼ��Spring,��Ҫ�ṩ�����ļ�
		//�����ļ�Ĭ��λ��Ϊ resources
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring�о��Ѿ�������HelloWorld��������ID��ȡSpring�д����Ķ���
		HelloWorld obj = (HelloWorld)ctx.getBean("obj1");
		//����Ƿ�ɹ������˶���
		System.out.println(obj);
	}
	@Test
	public void testName(){
		HelloWorld obj = (HelloWorld)ctx.getBean("obj2");
		System.out.println(obj);
	}
	
	@Test
	public void testGetBean(){
		//Spring�����ṩ�˶����ȡBean����ķ���
		HelloWorld bean1 = (HelloWorld) ctx.getBean("obj1");
		System.out.println(bean1);
		//���ؾ������͵ķ�������������ת�������ã�
		HelloWorld bean2 = ctx.getBean("obj1",HelloWorld.class);
		System.out.println(bean2);
		
		
	}
	
	@Test
	public void testCalendar(){
		//��̬����getInstance(),������Calendar����
		//��������ľ�̬������Ϊ����̬����������
		//Calendar cal = Calendar.getInstance();
		  
		//Ϊ���о�̬����������
		
		
		//Spring֧�־�̬����������������
		/*
		 * Spring����ȥ���þ�̬�����������������Ķ���
		 * �ŵ�Spring���������������ṩ���ⲿʹ��
		 */
		
		
		Calendar cal1 = ctx.getBean("cal1",Calendar.class);
		System.out.println(cal1);
	}
	@Test
	public void testFactoryBean(){
		//��������Spring����Bean����Ĺ���������������
		Date date = ctx.getBean("date1",Date.class);
		System.out.println(date);
	}
	@Test
	public void testPrototype(){
		//Ĭ������£�Spring����Ķ����ǵ����� 
		HelloWorld obj1 = ctx.getBean("obj1",HelloWorld.class);
		HelloWorld obj2 = ctx.getBean("obj1",HelloWorld.class);
		System.out.println(obj1==obj2);
		//������scope=prototype  ���Է����Ƕ�����
		HelloWorld obj3 = ctx.getBean("obj3",HelloWorld.class);
		HelloWorld obj4 = ctx.getBean("obj3",HelloWorld.class);
		System.out.println(obj3==obj4);
		
	}
	@Test
	public void testLifecircle(){
		//����Spring��Bean������������ڹ�����
		DemoBean bean = ctx.getBean("demo",DemoBean.class);
		bean.print("������⣬ǧ����⣬����ѩƮ");
	}
	@Test
	public void testPrototypeLifecircle(){
		//����Spring��Bean������������ڹ�����
		DemoBean2 bean = ctx.getBean("demo2",DemoBean2.class);
		bean.print("������⣬ǧ����⣬����ѩƮ");
		//�ֹ��������ٷ���
		bean.destroy();
	}
}
