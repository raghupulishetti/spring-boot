package com.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.raghu.bean.User;
import com.raghu.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String registerUser(User user) {
		String msg = "Registration is Failure!Please Try Again";
		try {
			if (user != null) {
				int count = userDao.registerUser(user);
				if (count > 0) {
					msg = "Registration is success";
				}
			}
		} catch (DataAccessException de) {
			msg = "Unable to process your request!please try agin";
			System.out.println("Exception Occured while registering the user :: " + de.getMessage());
		}
		return msg;
	}

	@Override
	public String updateUserMobile(Integer userId, String mobile) {
		String msg = "Mobile Update is Failure!Please Try Again";
		try {
			if (userId != null && userId > 0 && mobile != null) {
				int count = userDao.updateUserMobile(userId, mobile);
				if (count > 0) {
					msg = "Mobile Updated Successfully";
				}
			}
		} catch (DataAccessException de) {
			msg = "Unable to process your request!please try agin";
			System.out.println("Exception Occured while updating the user mobile :: " + de.getMessage());
		}
		return msg;
	}

	@Override
	public String deleteUser(Integer userId) {
		String msg = "User Not Deleted !Please Try Again";
		try {
			if (userId != null && userId > 0) {
				int count = userDao.deleteUser(userId);
				if (count > 0) {
					msg = "User Deleted Successfully";
				} else {
					msg = "User Not Found";
				}
			}
		} catch (DataAccessException de) {
			msg = "Unable to process your request!please try agin";
			System.out.println("Exception Occured while deleting the user  :: " + de.getMessage());
		}
		return msg;
	}

}
