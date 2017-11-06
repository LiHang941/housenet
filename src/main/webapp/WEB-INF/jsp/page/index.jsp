<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/3
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${basePath}ref/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${basePath}scripts/jquery-2.1.3.min.js"></script>
    <script src="${basePath}ref/bootstrap/js/bootstrap.min.js"></script>
    <title>租房网</title>
</head>
<body style="font-family: Arial,'微软雅黑', sans-serif; font-size:12px;">
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${basePath}indexUI.do">
                <img alt="Brand" src="${basePath}images/logo.gif" style="height: 25px;border-radius: 25px;">
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${basePath}admin/managerUI.do">登陆</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="${basePath}index.do" method="post" name="actionForm">
                <input type="hidden" name="page.p" value="" id="pageIndex"/>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">住房类型</div>
                        <select class="form-control" name="range.typeId">
                            <option value="">请选择</option>
                            <c:forEach items="${requestScope.typeList}" var="typeEntity">
                                <option value="${typeEntity.id}"
                                        <s:if test="#attr.typeEntity.id == range.typeId">
                                            selected
                                        </s:if>
                                >${typeEntity.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">面积范围</div>
                        <input type="text" class="form-control" name="range.startFloorage" value="<s:property value="range.startFloorage"/>"  placeholder="起始" style="width: 60px;">
                        <input type="text" class="form-control" name="range.endFloorage" value="<s:property value="range.endFloorage"/>"  placeholder="结束" style="width: 60px;">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">价格范围</div>
                        <input type="text" class="form-control" name="range.startPrice" value="<s:property value="range.startPrice"/>"  placeholder="起始" style="width: 60px;"/>
                        <input type="text" class="form-control" name="range.endPrice" value="<s:property value="range.endPrice"/>"  placeholder="结束" style="width: 60px;"/>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索标题" name="keywords" value="<s:property value="keywords"/>"/>
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="container">
        <div class="page-header">
            <h1>青鸟租房<small>专业房屋出租出售网络平台</small></h1>
        </div>

        <div class="row">

            <c:forEach items="${requestScope.houseList}" var="houseEntity" varStatus="vs">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="${basePath}images/thumb_house.gif" style="width: 100%">
                    <div class="caption">
                        <h3>${houseEntity.title}</h3>
                        <p class="text-danger"><small>${houseEntity.description}</small></p>
                        <table  class="table">
                            <tr>
                                <th>户型</th>
                                <td>${houseEntity.typeByTypeId.name}</td>
                                <th>价格</th>
                                <td>${houseEntity.price}</td>
                            </tr>
                            <tr>
                                <th>面积</th>
                                <td>${houseEntity.floorage}m²</td>
                                <th>位置</th>
                                <td>${houseEntity.streetByStreetId.districtByDistrictId.name}
                                    &nbsp;
                                    ${houseEntity.streetByStreetId.name}</td>
                            </tr>
                        </table>
                        <p><a href="${basePath}showUI.do?house.id=${houseEntity.id}" class="btn btn-default" role="button">查看详细</a></p>
                    </div>
                </div>
            </div>
            <c:if test="${  (vs.index+1) % 3 == 0}">
                </div>
                <div class="row">
            </c:if>
            </c:forEach>
        </div>
        <nav aria-label="Page navigation">
            <ul class="pagination pagination-lg">
                    <li>
                        <a href="${basePath}index.do" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="pageIndex" items="${requestScope.pageList}" varStatus="vs">
                        <li  <s:if test="page.currentPage == #attr.pageIndex"> class="active"</s:if>
                                ><a href="javascript:toPage(${pageIndex});">${pageIndex}</a></li>
                    </c:forEach>
                    <li>
                        <a href="javascript:toPage(<s:property value="page.totalPage"/>);"aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
            </ul>
        </nav>

    </div>
</div>
<dl style="text-align: center">
    <dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
    <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
</dl>
<script>
    function toPage(index) {
        document.getElementById("pageIndex").value = index;
        document.forms.actionForm.submit();
    }
</script>
</body>
</html>
