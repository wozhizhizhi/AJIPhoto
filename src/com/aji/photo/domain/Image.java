package com.aji.photo.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Image implements Serializable
{
	// ͼƬ��ID
	private int id;
	// ͼƬ������
	private String name;
	// ͼƬ�ĵ�ַ
	private String url;
	// �ϴ���ʱ��
	private Date date;
	// �������û�
	private User user;
	
	public Image() {}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date objects)
	{
		this.date = objects;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
}
