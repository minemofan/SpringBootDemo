package com.example.demo;

import com.example.holle.SpringBootDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	private SpringBootDemoApplication springBootDemoApplication;


	@Test
	public void contextLoads() {
		System.out.println("sss:"+ springBootDemoApplication);
	}

}
