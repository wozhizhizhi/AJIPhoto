package com.aji.photo.service;

import java.util.ArrayList;

import com.aji.photo.domain.User;
import com.aji.photo.util.DBUtil;

public class UserService
{
	/**
	 * 通过用户名字获取用户
	 * @param userName 用户名
	 * @return 返回用户
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
	 * 添加新用户
	 * @param user 用户
	 */
	public void addUser(User user)
	{
		String[] sqls = {"insert into user(username , password) value(? , ?)"};
		String[][] parameters = {{user.getUsername() , user.getPassword()}};
		DBUtil.updates(sqls, parameters);
	}
}
