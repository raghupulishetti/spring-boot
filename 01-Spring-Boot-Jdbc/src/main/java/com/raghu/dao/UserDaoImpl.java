package com.raghu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.raghu.bean.UpdateUserMobilePreparedStatementSetter;
import com.raghu.bean.User;
import com.raghu.util.SQLConstants;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int registerUser(User user) {
		int count = jdbcTemplate.update(SQLConstants.SQL_REGISTER_USER, user.getUserId(), user.getName(),
				user.getEmail(), user.getMobile());
		return count;
	}

	// with anonymous inner class:-
	@Override
	public int updateUserMobile(final Integer userId, final String mobile) {
		/*int count = jdbcTemplate.update(SQLConstants.SQL_UPDATE_MOBILE, new PreparedStatementSetter() {// start of AIC
			public void setValues(PreparedStatement pst) throws SQLException {
				pst.setString(1, mobile);
				pst.setInt(2, userId);
			}
		}); */// end of AIC and update() method call return
		int count = jdbcTemplate.update(SQLConstants.SQL_UPDATE_MOBILE, new UpdateUserMobilePreparedStatementSetter(mobile,userId));
		return count;
	}

	// with anonymous inner class:-
	@Override
	public int deleteUser(final Integer userId) {
		int count = jdbcTemplate.update(new PreparedStatementCreator() {// start of AIC public
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(SQLConstants.SQL_DELETE_USER);
				pst.setInt(1, userId);
				return pst;
			}
		});// end of AIC and update method call

		return count;
	}

	// with Java Lambda Expressions
	/*@Override
	public int deleteUser(final Integer userId) {
		int count = jdbcTemplate.update((Connection con) -> {
			PreparedStatement pst = con.prepareStatement(SQLConstants.SQL_DELETE_USER);
			pst.setInt(1, userId);
			return pst;
		});// end of Lambda Expression and update method call

		return count;
	}

	// with Java Lambda Expressions
	@Override
	public int updateUserMobile(final Integer userId, final String mobile) {
		int count = jdbcTemplate.update(SQLConstants.SQL_UPDATE_MOBILE, (PreparedStatement pst) -> {
			pst.setString(1, mobile);
			pst.setInt(2, userId);
		});
		return count;
	}*/

}
