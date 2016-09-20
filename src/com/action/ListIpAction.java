package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;
import com.dao.ProjectDao;
import com.entity.User;

public class ListIpAction extends BaseAction{



	private JSONObject result;//���ص�json   
    
    private String rows;//ÿҳ��ʾ�ļ�¼��   
        
    private String page;//��ǰ�ڼ�ҳ   
    
    private ProjectDao dao;   
	
	private int totalSize;//�ܼ�¼��

	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
    public JSONObject getResult() {   
        return result;   
    }   
    public void setResult(JSONObject result) {   
        this.result = result;   
    }   
    public void setAppService(ProjectDao dao) {   
        this.dao = dao;   
    }   
    
        public String getRows() {   
        return rows;   
    }   
    public void setRows(String rows) {   
        this.rows = rows;   
    }   
    public String getPage() {   
        return page;   
    }   
    public void setPage(String page) {   
        this.page = page;   
    }  
    public String forSend(){
		return "success";
	}
        /**  
     * ��ѯ  
     * @return  
     */  
    public String listIP() {   
        System.out.println("---------------");   
        HttpServletRequest re = ServletActionContext.getRequest();

        HttpServletResponse response = ServletActionContext.getResponse();

        response.setCharacterEncoding("UTF-8");

        try {
			PrintWriter out = response.getWriter();
		


        //��ǰҳ   page�ɷ�ҳ���߸��𴫹���
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);   
        //ÿҳ��ʾ����   
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows);   
        //ÿҳ�Ŀ�ʼ��¼  ��һҳΪ1  �ڶ�ҳΪnumber +1    
        int start = (intPage-1)*number;   
        ProjectDao dao=new ProjectDao();    
        List<User> list = dao.findByPage(start,number);//ÿҳ�����ݣ�����list   
        Map<String, Object> jsonMap = new HashMap<String, Object>();//����map   
        jsonMap.put("total", dao.getCount());//total�� ����ܼ�¼���������   ,EasyUI����������������Լ���page��number��ֵ�����ֵ����users�ĳ���
        jsonMap.put("rows", list);//rows�� ���ÿҳ��¼ list   
        totalSize =dao.getCount();
        
        result = JSONObject.fromObject(jsonMap);//��ʽ��result   һ��Ҫ��JSONObject   
        System.out.println(result.toString());
        out.print(result);
        out.flush();
        out.close();

    //result = JSONArray.fromObject(jsonMap);    
        } catch (IOException e) {
			e.printStackTrace();
		}
        return "success";   
    }
}
