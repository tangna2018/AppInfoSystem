<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="common/header.jsp"%>
<div class="page-title">
                    <div class="title_left">
                        <h4>欢迎您：测试账户test001<strong>|角色：开发者账户</strong></h4>
                    </div>
    </div>
<%@include file="common/footer.jsp"%>

