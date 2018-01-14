package com.aji.photo.util;

import java.io.InputStream;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;

public class FileUtils
{
	// ��ţ��Կ
	private static final String ACCESS_KEY = ""; 
    private static final String SECRET_KEY = "";
    // Bucket ����
    private static final String BUCKET_NAME = "";

    /**
     * �ϴ�ͼƬ����ţ�ƴ洢
     * @param reader
     * @param fileName
     */
    public static void upload(InputStream reader, String fileName) {
        String uptoken;
        try 
        {
            Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
            PutPolicy putPolicy = new PutPolicy(BUCKET_NAME);
            uptoken = putPolicy.token(mac);
            IoApi.Put(uptoken, fileName, reader, null);
        } 
        catch (AuthException e)
        {
            e.printStackTrace();
        } 
        catch (JSONException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * ɾ����ţ�ƴ洢�ϵ�ͼƬ
     * @param key
     */
    public static void delete(String key)
    {
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        RSClient client = new RSClient(mac);
        client.delete(BUCKET_NAME, key);
    }
}
