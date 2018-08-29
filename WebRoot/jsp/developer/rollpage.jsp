<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rollpage.jsp' starting page</title>
  </head>
  
  <body>
  <div style="float:left">
        <li>共?条记录&nbsp;&nbsp; ?/?页</li>
    </div>
    <div style="float:right">
        	<div class="row">
              <div class="btn-toolbar">
                <div class="btn-group">
                  <button class="btn btn-info" type="button">首页</button>
                  <button class="btn btn-info active" type="button">上一页</button>
                  <button class="btn btn-info" type="button">下一页</button>
                  <button class="btn btn-info" type="button">尾页</button>
                </div>
              </div>
            </div>
        </div>
  </body>
</html>
