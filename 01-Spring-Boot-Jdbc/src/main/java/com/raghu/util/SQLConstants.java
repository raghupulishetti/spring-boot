package com.raghu.util;

public class SQLConstants {
	public static final String SQL_REGISTER_USER = "insert into user values(?,?,?,?)";
	public static final String SQL_UPDATE_MOBILE = "update user set mobile=? where userid=?";
	public static final String SQL_DELETE_USER = "delete from user where userid=?";
}
