package com.raghu.bean;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class UpdateUserMobilePreparedStatementSetter implements PreparedStatementSetter {
	private String mobileNo;
	private Integer userId;

	public UpdateUserMobilePreparedStatementSetter(String mobileNo, Integer userId) {
		this.mobileNo = mobileNo;
		this.userId = userId;
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1, mobileNo);
		ps.setInt(2, userId);

	}

}
