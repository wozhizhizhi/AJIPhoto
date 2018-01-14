package com.aji.photo.service;

import java.util.ArrayList;

import com.aji.photo.domain.User;
import com.aji.photo.util.DBUtil;

public class UserService
{
	/**
	 * ͨ���û����ֻ�ȡ�û�
	 * @param userName �û���
	 * @return �����û�
	 */
	public User getUserByUserName(String userName)
	{
		String sql = "select id , username , password from user where username = ?";
		String[] parameters = {userName};
		ArrayList<Object[]> users = DBUtil.query(sql, parameters);
		if (users.size() == 0) 
		{
            return null;
        } 
		else 
		{
            Object[] objects = users.get(0);
            return objects == null ? null : new User(Integer.parseInt(objects[0].toString()), objects[1].toString(), objects[2].toString(), null);
        }
	}
	
	/**
	 * ������û�
	 * @param user �û�
	 */
	public void addUser(User user)
	{
		String[] sqls = {"insert into user(username , password) value(? , ?)"};
		String[][] parameters = {{user.getUsername() , user.getPassword()}};
		DBUtil.updates(sqls, parameters);
	}
}
