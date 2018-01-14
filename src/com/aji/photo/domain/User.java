package com.aji.photo.domain;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class User implements Serializable
{
	// �û���ID
	private int id;
	// �û�������
	private String username;
	// �û�������
	private String password;
	// �û���ͼƬ����
	private List<Image> images;
	
	public User() {}
	
	public User(int id , String userName , String passWord , List<Image> images)
	{
		this.id = id;
		this.username = userName;
		this.password = passWord;
		this.images = images;
	}
	
	public User(String userName , String passWord)
	{
		this.username = userName;
		this.password = passWord;
	}
	
	public User(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<Image> getImages()
	{
		return images;
	}

	public void setImages(List<Image> images)
	{
		this.images = images;
	}	
}
