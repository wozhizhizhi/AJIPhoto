package com.aji.photo.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aji.photo.domain.Image;
import com.aji.photo.domain.User;
import com.aji.photo.util.DBUtil;
import com.aji.photo.util.FileUtils;

/**
 * ͼƬ������
 */
public class ImageService 
{
    /**
     * ͨ���û�ID��ȡͼƬ�б�
     * @param userId �û�ID
     * @return ͼƬ�б�
     */
    public ArrayList<Image> getByUserId(int userId)
    {
        ArrayList<Image> images = new ArrayList<Image>();
        String sql = "select id, name, url, date, user_id from image where user_id = ? order by date desc";
        String[] parameters = {userId + ""};
        List<Object[]> imageList = DBUtil.query(sql, parameters);
        for (Object[] objects : imageList) 
        {
            Image image = new Image();
            image.setId(Integer.parseInt(objects[0].toString()));
            image.setName(objects[1].toString());
            image.setUrl(objects[2].toString());
            image.setDate((Date) objects[3]);
            image.setUser(new User(Integer.parseInt(objects[4].toString())));
            images.add(image);
        }
        return images;
    }

    /**
     * �ϴ�ͼƬ
     * @param image ͼƬ
     * @param inputStream ������
     */
    public void addImage(Image image, InputStream inputStream) 
    {
    	FileUtils.upload(inputStream, image.getUrl());
        String[] sqls = {"insert into image(name, url, date, user_id) values(?, ?, ?, ?)"};
        String[][] parameters = {{image.getName(), image.getUrl(), new SimpleDateFormat("yyyy-MM-dd HH:mm").format(image.getDate()), image.getUser().getId() + ""}};
        DBUtil.updates(sqls, parameters);
    }

    /**
     * ͨ��ͼƬID�����ͼƬURL����ɾ��ͼƬ
     * @param ids ͼƬID����
     * @param urls ͼƬURL����
     */
    public void delByIdsAndUrls(String ids, String urls)
    {
        String[] idArray = ids.split(",");
        String[] urlArray = urls.split(",");
        if (!"".equals(idArray[0]) && !"".equals(urlArray[0]))
        {
            String[] sqls = new String[idArray.length];
            String[][] parameters = new String[idArray.length][1];
            for (int i = 0; i < idArray.length; i++) 
            {
                FileUtils.delete(urlArray[i]);
                sqls[i] = "delete from image where id = ?";
                parameters[i][0] = idArray[i];
            }
            DBUtil.updates(sqls, parameters);
        }
    }
}
