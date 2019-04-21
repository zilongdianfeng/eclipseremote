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
		//初始化Spring,需要提供配置文件
		//配置文件默认位置为 resources
		 ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@After//在测试案例之后执行
	public void destroy(){
		ctx.close();//关闭Spring容器，会销毁Bean对象
	}
	@Test
	public void testHelloWorld(){
		//初始化Spring,需要提供配置文件
		//配置文件默认位置为 resources
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring中就已经创建了HelloWorld对象，利用ID获取Spring中创建的对象
		HelloWorld obj = (HelloWorld)ctx.getBean("obj1");
		//检查是否成功创建了对象
		System.out.println(obj);
	}
	@Test
	public void testName(){
		HelloWorld obj = (HelloWorld)ctx.getBean("obj2");
		System.out.println(obj);
	}
	
	@Test
	public void testGetBean(){
		//Spring容器提供了多个获取Bean对象的方法
		HelloWorld bean1 = (HelloWorld) ctx.getBean("obj1");
		System.out.println(bean1);
		//返回具体类型的方法，无需类型转换（常用）
		HelloWorld bean2 = ctx.getBean("obj1",HelloWorld.class);
		System.out.println(bean2);
		
		
	}
	
	@Test
	public void testCalendar(){
		//静态方法getInstance(),来创建Calendar对象
		//创建对象的静态方法称为，静态工厂方法。
		//Calendar cal = Calendar.getInstance();
		  
		//为何有静态工厂方法？
		
		
		//Spring支持静态工厂方法创建对象
		/*
		 * Spring可以去调用静态工厂方法，将创建的对象
		 * 放到Spring容器管理起来，提供给外部使用
		 */
		
		
		Calendar cal1 = ctx.getBean("cal1",Calendar.class);
		System.out.println(cal1);
	}
	@Test
	public void testFactoryBean(){
		//测试利用Spring调用Bean对象的工厂方法创建对象
		Date date = ctx.getBean("date1",Date.class);
		System.out.println(date);
	}
	@Test
	public void testPrototype(){
		//默认情况下，Spring管理的对象是单例的 
		HelloWorld obj1 = ctx.getBean("obj1",HelloWorld.class);
		HelloWorld obj2 = ctx.getBean("obj1",HelloWorld.class);
		System.out.println(obj1==obj2);
		//设置了scope=prototype  属性返回是多例的
		HelloWorld obj3 = ctx.getBean("obj3",HelloWorld.class);
		HelloWorld obj4 = ctx.getBean("obj3",HelloWorld.class);
		System.out.println(obj3==obj4);
		
	}
	@Test
	public void testLifecircle(){
		//测试Spring的Bean对象的生命周期管理功能
		DemoBean bean = ctx.getBean("demo",DemoBean.class);
		bean.print("北国风光，千里冰封，万里雪飘");
	}
	@Test
	public void testPrototypeLifecircle(){
		//测试Spring的Bean对象的生命周期管理功能
		DemoBean2 bean = ctx.getBean("demo2",DemoBean2.class);
		bean.print("北国风光，千里冰封，万里雪飘");
		//手工调用销毁方法
		bean.destroy();
	}
}
