package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dao.ProjectDao;
import com.entity.User;

import net.sf.json.JSONObject;

public class UserAction extends BaseAction{
	private JSONObject result;//返回的json
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public String addUser() {   
        System.out.println("新增11111111111111111");   
        try {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
       // response.setContentType( "text/html;charset=utf-8");       
        PrintWriter out = response.getWriter();
		
        int t_id = Integer.parseInt(request.getParameter("t_id"));
        String t_name = request.getParameter("t_name");
        String t_email = request.getParameter("t_email");
        String t_inip = request.getParameter("t_inip");
        String t_outip = request.getParameter("t_outip");
        String t_mac = request.getParameter("t_mac");
        String t_dept = request.getParameter("t_dept");
        String t_team = request.getParameter("t_team");
        User user=new User();
        user.setT_id(t_id);
        user.setT_name(t_name);
        user.setT_email(t_email);
        user.setT_inip(t_inip);
        user.setT_outip(t_outip);
        user.setT_mac(t_mac);
        user.setT_dept(t_dept);
        user.setT_team(t_team);
        ProjectDao dao=new ProjectDao();
        dao.addUser(user);
        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
        jsonMap.put("success", true);
        result = JSONObject.fromObject(jsonMap);//格式化result   一定要是JSONObject   
        System.out.println(result.toString());
        out.print(result);
        out.flush();
        out.close();
        } catch (IOException e) {
			e.printStackTrace();
		}
        return "success";   
    }
	
	/**
     * 修改
     * @return
     * @throws IOException
     */
    public String EditUser() throws IOException{
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
       // response.setContentType( "text/html;charset=utf-8");       
        PrintWriter out = response.getWriter();
    	int id =Integer.parseInt(request.getParameter("id"));
//    	int t_id = Integer.parseInt(request.getParameter("t_id"));
//    	System.out.println(id+"////"+t_id);
        int t_id = Integer.parseInt(request.getParameter("t_id"));
        String t_name = request.getParameter("t_name");
        String t_email = request.getParameter("t_email");
        String t_inip = request.getParameter("t_inip");
        String t_outip = request.getParameter("t_outip");
        String t_mac = request.getParameter("t_mac");
        String t_dept = request.getParameter("t_dept");
        String t_team = request.getParameter("t_team");
        User user=new User();
        user.setT_id(t_id);
        user.setT_name(t_name);
        user.setT_email(t_email);
        user.setT_inip(t_inip);
        user.setT_outip(t_outip);
        user.setT_mac(t_mac);
        user.setT_dept(t_dept);
        user.setT_team(t_team);
        ProjectDao dao=new ProjectDao();
        dao.editUser(user);    	
    	Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
    	jsonMap.put("success", true);
        result = JSONObject.fromObject(jsonMap);//格式化result   一定要是JSONObject   
        System.out.println(result.toString());     
        out.print(result);
        out.flush();
        out.close();
        return null;
    }

	/**
     * 删除
     * @return
     * @throws IOException
     */
    public String RemoveUser() throws IOException{
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
       // response.setContentType( "text/html;charset=utf-8");       
        PrintWriter out = response.getWriter();
    	int id =Integer.parseInt(request.getParameter("id"));
        ProjectDao dao=new ProjectDao();
        dao.removeUser(id);    	
    	Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
    	jsonMap.put("success", true);
        result = JSONObject.fromObject(jsonMap);//格式化result   一定要是JSONObject   
        System.out.println(result.toString());     
        out.print(result);
        out.flush();
        out.close();
        return null;
    }
    
}
