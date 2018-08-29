<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="common/header.jsp"%>
<!-- 查询操作 -->
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h>APP 审核列表 </h>&nbsp;<i class="fa fa-paw"></i><small>
        ${userSession.userName}
						- 您可以通过搜索或者其他的筛选项对APP的信息进行审核操作。^_^</small>
        <div class="clearfix"></div>
      <div class="x_content">
	<form method="post" action="list">
			<input type="hidden" name="pageIndex" value="1" />
		<ul></br></ul>
	    <ul>
			<li>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<input name="querySoftwareName" type="text" class="form-control col-md-7 col-xs-12" value="${querySoftwareName }">
					</div>
				</div>
			</li>
			<li>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<select name="queryFlatformId" class="form-control">
						<c:if test="${flatFormList != null }">
						   <option value="">--请选择--</option>
						   <c:forEach var="dataDictionary" items="${flatFormList}">
						   		<option <c:if test="${dataDictionary.valueId == queryFlatformId }">selected="selected"</c:if>
						   		value="${dataDictionary.valueId}">${dataDictionary.valueName}</option>
						   </c:forEach>
						</c:if>
     						</select>
				</div>
			</div>
		</li>
			<li>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<select id="queryCategoryLevel1" name="queryCategoryLevel1" class="form-control">
						<c:if test="${categoryLevel1List != null }">
							   <option value="">--请选择--</option>
							    <c:forEach var="appCategory" items="${categoryLevel1List}">
						   		<option <c:if test="${appCategory.id == queryCategoryLevel1 }">selected="selected"</c:if>
						   		value="${appCategory.id}">${appCategory.categoryName}</option>
						   </c:forEach>
						</c:if>
      					</select>
					</div>
				</div>
			</li>
			<li>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
      						<select name="queryCategoryLevel2" id="queryCategoryLevel2" class="form-control">
							   <c:if test="${categoryLevel2List != null }">
							   <option value="">--请选择--</option>
							   <c:forEach var="appCategory" items="${categoryLevel2List}">
						   		<option <c:if test="${appCategory.id == queryCategoryLevel2 }">selected="selected"</c:if>
						   		value="${appCategory.id}">${appCategory.categoryName}</option>
						   </c:forEach>
						</c:if>
      				</select>
					</div>
				</div>
			</li>
			<li>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
      						<select name="queryCategoryLevel3" id="queryCategoryLevel3" class="form-control">
							  <c:if test="${categoryLevel3List != null }">
							   <option value="">--请选择--</option>
							   <c:forEach var="appCategory" items="${categoryLevel3List}">
						   		<option <c:if test="${appCategory.id == queryCategoryLevel3 }">selected="selected"</c:if>
						   		value="${appCategory.id}">${appCategory.categoryName}</option>
						   </c:forEach>
						</c:if>
      					</select>
					</div>
				</div>
			</li>
			<li><button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button></li>
		</ul>
	</form>
  </div>
  </div>
</div>
</div>
</div>

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <button type="submit" class="btn btn-info btn-sm">新增APP信息</button>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <table id="datatable" class="table table-striped table-bordered">
          <thead>
            <tr>
              <th>软件名称</th>
              <th>APK名称</th>
              <th>软件大小(单位：M)</th>
              <th>所属平台</th>
              <th>所属分类(一级分类、二级分类、三级分)</th>
              <th>状态</th>
              <th>下载次数</th>
              <th>最新版本</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
          <%-- <c:forEach var="appInfo" items="${appInfoList }" varStatus="status"> --%>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>
              <div class="btn-group">
                  <button type="button" class="btn btn-default checkApp" 
											appinfoid="${appInfo.id }" versionid="${appInfo.versionId }" status="${appInfo.status }" 
											statusname="${appInfo.statusName }"											
											data-toggle="tooltip" data-placement="top" title="" 
											data-original-title="查看并审核APP">审核
				  </button>
                </div>
              </td>
            </tr>
            <%-- </c:forEach> --%>
          </tbody>
        </table>
        <!-- 分页 -->
        <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
      </div>
    </div>
  </div>
<!-- 信息显示 -->
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/applist.js"></script>