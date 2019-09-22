package com.raghu.service;

import com.raghu.bean.User;

public interface UserService {
	public String registerUser(User user);
	public String updateUserMobile(Integer userId, String mobile);
	public String deleteUser(Integer userId);
}
