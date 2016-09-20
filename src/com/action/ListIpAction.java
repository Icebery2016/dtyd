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



	private JSONObject result;//返回的json   
    
    private String rows;//每页显示的记录数   
        
    private String page;//当前第几页   
    
    private ProjectDao dao;   
	
	private int totalSize;//总记录数

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
     * 查询  
     * @return  
     */  
    public String listIP() {   
        System.out.println("---------------");   
        HttpServletRequest re = ServletActionContext.getRequest();

        HttpServletResponse response = ServletActionContext.getResponse();

        response.setCharacterEncoding("UTF-8");

        try {
			PrintWriter out = response.getWriter();
		


        //当前页   page由分页工具负责传过来
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);   
        //每页显示条数   
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows);   
        //每页的开始记录  第一页为1  第二页为number +1    
        int start = (intPage-1)*number;   
        ProjectDao dao=new ProjectDao();    
        List<User> list = dao.findByPage(start,number);//每页的数据，放入list   
        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map   
        jsonMap.put("total", dao.getCount());//total键 存放总记录数，必须的   ,EasyUI根据这个参数，可以计算page和number的值，这个值不是users的长度
        jsonMap.put("rows", list);//rows键 存放每页记录 list   
        totalSize =dao.getCount();
        
        result = JSONObject.fromObject(jsonMap);//格式化result   一定要是JSONObject   
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
