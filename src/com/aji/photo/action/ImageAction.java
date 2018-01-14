package com.aji.photo.action;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aji.photo.domain.Image;
import com.aji.photo.domain.User;
import com.aji.photo.service.ImageService;

/**
 * Í¼Æ¬µÄ¿ØÖÆÆ÷
 * @author aji
 *
 */
@WebServlet(value = "/ImageAction")
@MultipartConfig
public class ImageAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int type = Integer.parseInt(request.getParameter("type"), 10);
        ImageService imageService = new ImageService();

        if (type == 1) 
        {    //ÉÏ´«Í¼Æ¬
            String imageName = request.getParameter("image_name");
            Part image = request.getPart("image");
            Image img = new Image();
            img.setDate(new Date());
            img.setName(imageName);
            img.setUser((User) request.getSession().getAttribute("user"));
            img.setUrl(img.getUser().getUsername() + "/" + UUID.randomUUID());
            imageService.addImage(img, image.getInputStream());
            request.getSession().setAttribute("imageList", imageService.getByUserId(img.getUser().getId()));
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } 
        else if (type == 2) 
        {    //É¾³ýÍ¼Æ¬
            String ids = request.getParameter("ids");
            String urls = request.getParameter("urls");
            imageService.delByIdsAndUrls(ids, urls);
            request.getSession().setAttribute("imageList", imageService.getByUserId(((User) request.getSession().getAttribute("user")).getId()));
       }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
