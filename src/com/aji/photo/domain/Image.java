package com.aji.photo.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Image implements Serializable
{
	// 图片的ID
	private int id;
	// 图片的名称
	private String name;
	// 图片的地址
	private String url;
	// 上传的时间
	private Date date;
	// 所属的用户
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
