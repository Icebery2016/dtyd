<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css"> 
        #fm 
        { 
            margin: 0; 
            padding: 10px 30px; 
        } 
        .ftitle 
        { 
            font-size: 14px; 
            font-weight: bold; 
            padding: 5px 0; 
            margin-bottom: 10px; 
            border-bottom: 1px solid #ccc; 
        } 
        .fitem 
        { 
            margin-bottom: 5px; 
        } 
        .fitem label 
        { 
            display: inline-block; 
            width: 80px; 
        } 
</style> 
<div id="dlg" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px;"
       closed="true" buttons="#dlg-buttons"> 
       <div class="ftitle"> 
           信息编辑 
       </div> 
       <form id="fm" method="post"> 
       <div class="fitem"> 
           <label> 
               编号 
           </label> 
           <input name="AccountCode" class="easyui-validatebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               卡号</label> 
           <input name="AccountName" class="easyui-validatebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               密码</label> 
           <input name="AccountPwd" class="easyui-validatebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               创建时间</label> 
           <input name="CreateTime" class="easyui-datebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               创建人</label> 
           <input name="CreateName" class="easyui-vlidatebox" /> 
       </div> 
       <input type="hidden" name="action" id="hidtype" /> 
       <input type="hidden" name="ID" id="Nameid" /> 
       </form> 
   </div> 
?<div id="dlg-buttons"> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()" iconcls="icon-save">保存</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')"
            iconcls="icon-cancel">取消</a> 
    </div> 