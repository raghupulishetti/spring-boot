package com.raghu;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raghu.dao.UserDao;
import com.raghu.entity.User;

@SpringBootApplication
public class Application  implements CommandLineRunner{

	
	@Autowired
	DataSource dataSource;

	@Autowired
	UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + dataSource);
		User user = new User();
		// user.setUserId(1001l);
		user.setName("Shravan");
		user.setEmail("shravan@gmail.com");
		user.setMobile("9888654236");
		user.setAge(35);
		//System.out.println(userDao.createUser(user));
		
		List<User> users = userDao.getUsers();
		for (User u : users) {
			System.out.println(u);
		}
	}
	
	
}
