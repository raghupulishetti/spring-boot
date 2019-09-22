package com.raghu.dao;

import com.raghu.bean.User;

public interface UserDao {
	public int registerUser(User user);
	public int updateUserMobile(final Integer userId, final String mobile);
	public int deleteUser(final Integer userId);
}
