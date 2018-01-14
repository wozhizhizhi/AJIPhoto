package com.aji.photo.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aji.photo.domain.User;
import com.aji.photo.service.ImageService;
import com.aji.photo.service.UserService;
/**
 * �û��Ŀ����� 
 * @author aji
 *
 */
@WebServlet(value = "/UserAction")
public class UserAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        UserService userService = new UserService();
        ImageService imageService = new ImageService();

        Integer type = Integer.valueOf(request.getParameter("type"));
        if (type == 1) 
        {    //�û���¼
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String result = null;
            User user = null;
            //��֤�û��Ƿ���Ч
            if (username.isEmpty()) 
            {
                result = "1";
            } 
            else if (password.isEmpty()) 
            {
                result = "2";
            } 
            else if ((user = userService.getUserByUserName(username)) == null) {
                result = "3";
            }
            else 
            {
                if (!user.getPassword().equals(password)) 
                {
                    result = "4";
                } 
                else 
                {
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("imageList", imageService.getByUserId(user.getId()));
                    result = "5";
                }
            }
            out.print(result);
        } 
        else if (type == 2)
        {    //�û�ע��
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            String result = null;
            //��֤��Ч��
            if (username.isEmpty()) 
            {
                result = "1";
            } 
            else if (password.isEmpty())
            {
                result = "2";
            } 
            else if (repassword.isEmpty()) 
            {
                result = "3";
            } 
            else if (!repassword.equals(password)) 
            {
                result = "4";
            } 
            else if (userService.getUserByUserName(username) != null) 
            {
                result = "5";
            } 
            else 
            {
                User user = new User(username, password);
                //����û�
                userService.addUser(user);
                result = "6";
            }
            out.print(result);
        } 
        else if (type == 3)
        {    //�û��˳�
            request.getSession().invalidate();
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
}
