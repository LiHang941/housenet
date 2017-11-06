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
    <title>查看租房信息</title>
</head>
<body style="font-family: Arial,'微软雅黑', sans-serif; font-size:12px;">
    <div class="container">
        <div class="page-header">
            <a type="button"  class="btn btn-warning" href="javascript:window.history.back();">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> 返回列表
            </a>
            <h1>房屋<small>详细信息</small></h1>
        </div>
        <blockquote>
            <br/>
            <br/>
            <dl class="dl-horizontal">
                <dt>图片</dt>
                <dd><img src="${basePath}images/thumb_house.gif" class="img-rounded"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>标题</dt>
                <dd><s:property value="house.title"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>户型</dt>
                <dd><s:property value="house.typeByTypeId.name"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>价格</dt>
                <dd><s:property value="house.price"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>位置</dt>
                <dd>市:<s:property value="house.streetByStreetId.districtByDistrictId.name"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    区:<s:property value="house.streetByStreetId.name"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>面积</dt>
                <dd><s:property value="house.floorage"/>m²</dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>联系姓名</dt>
                <dd><s:property value="house.usersByUserId.name"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>联系方式</dt>
                <dd><abbr title="Phone">电话:</abbr><s:property value="house.usersByUserId.telephone"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>详细信息说明</dt>
                <dd><s:property value="house.description"/></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>发布时间</dt>
                <dd><s:date name="house.pubdate" format="yyyy年MM月dd日"/></dd>
            </dl>
            <br/>
            <br/>
            <footer>租房网</footer>
        </blockquote>
    </div>
    <dl style="text-align: center">
        <dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</body>
</html>
