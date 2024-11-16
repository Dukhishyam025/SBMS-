package in.ashokit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.beans.BookService;

public class MyApp {

	public static void main(String[] args) throws Exception {
     
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("beans.xml");
		BookService bean = ctxt.getBean(BookService.class);
		bean.bookService();
	}

}
  