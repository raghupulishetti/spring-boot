package com.raghu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional(readOnly = false)
	public long createUser(User user) {
		Long userId = (Long) hibernateTemplate.save(user);
		return userId;
	}

	@Override
	public User getUser(long userId) {
		String hql = "from com.raghu.entity.User where userId=:userId";
		List<User> list = (List<User>) hibernateTemplate.find(hql, userId);
		return list.get(0);
	}

	@Override

	public List<User> getUsers() {
		// HQL QUERY
		String hql = "from com.raghu.entity.User";
		List<User> list = (List<User>) hibernateTemplate.find(hql);
		return list;
	}

	@Override
	public int deleteUser(long userId) {
		String hql = "delete from com.raghu.entity.User as u" + " where u.userId=?";
		int count = hibernateTemplate.bulkUpdate(hql, userId);
		return count;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int updateUserProfile(User user) {
		String hql = "update com.raghu.entity.User as u" + " set u.name=?,u.age=?,u.email=?,u.mobile=? "
				+ "where u.userId=?";
		int count = hibernateTemplate.bulkUpdate(hql, user.getName(), user.getAge(), user.getEmail(), user.getMobile(),
				user.getUserId());

		return count;
	}

}
