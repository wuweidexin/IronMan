package com.chen.test;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.test.model.User;
import com.chen.test.service.UserService;


public class MyBatisTest {
	private UserService userService;
	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{
				"spring-context.xml",
				"springmvc-servlet.xml"
		});
		userService = (UserService)ac.getBean("userService");
	}
	@Test
	public void testFindAllUser(){
		List<User> userList = userService.findAllUser();
		for(User u : userList) {
			System.out.println("姓名是："+u.getUsername());
		}
	}
}
