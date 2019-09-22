package com.raghu;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.raghu.bean.User;
import com.raghu.service.UserService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	DataSource dataSource;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + dataSource);
		// UserService userService = (UserService) ctx.getBean("userService");
		// calling business logic method
		User user = new User();
		user.setUserId(1002);
		user.setName("Ramu");
		user.setEmail("ramu@gmail.com");
		user.setMobile("9888654236");
		System.out.println(userService.registerUser(user));
		// System.out.println(dataSource.to);
		// System.out.println(userService.updateUserMobile(1001, "9999999999"));
		// System.out.println(userService.deleteUser(1001));
	}
}
