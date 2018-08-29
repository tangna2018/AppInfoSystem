<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  		<div style="float:left">
			共${param.totalCount}条记录&nbsp;&nbsp; ${param.currentPageNo}/${param.totalPageCount}页
			</div>
			<div style="float:right">
				<c:if test="${param.currentPageNo > 1}">
					<a href="javascript:page_nav(document.forms[0],1);">首页</a>
					<a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a>
				</c:if>
				<c:if test="${param.currentPageNo < param.totalPageCount }">
					<a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});">下一页</a>
					<a href="javascript:page_nav(document.forms[0],${param.totalPageCount});">最后一页</a>
				</c:if>
				&nbsp;&nbsp;
			</div> 
  </body>
  <script type="text/javascript">
  	function page_nav(frm,num){
		frm.pageIndex.value = num;
		frm.submit();
}
  </script>
</html>

