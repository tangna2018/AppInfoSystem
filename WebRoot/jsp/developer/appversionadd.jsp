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
        <h>新增APP版本信息 </h>&nbsp;&nbsp;<i class="fa fa-paw"></i><small>test001</small>
        <div class="clearfix"></div>
      <div class="x_content">
      <h6>历史版本列表 </h6>
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
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>
              <div class="btn-group">
                  <button type="button" class="btn btn-danger">点击操作</button>
                  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" role="menu">
                  <li><a href="#">新增版本</a></li>
                  <li><a href="#">修改版本</a></li>
                  <li><a href="#">修改</a></li>
                  <li><a href="#">查看</a></li>
                  <li><a href="#">删除</a></li>
                </ul>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
        <!-- 分页 -->
        <!-- <div style="float:left">
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
        </div> -->
        <!-- 分页 -->
      </div>
    </div>
  </div>
  </div>
</div>
</div>
</div>
