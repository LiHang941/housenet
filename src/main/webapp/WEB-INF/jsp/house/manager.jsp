<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 用户管理</title>
	<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />
	<script type="text/javascript" src="${basePath}scripts/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${basePath}scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap" style="margin-top: 20px;">
	<div id="logo"><img src="${basePath}images/logo.gif" onclick="window.location.href='${basePath}admin/managerUI.do'"/></div>
	<div class="search" style="margin-top: 20px;">
		<form method="post" action="" id="gotoPage">
			<input class="text" type="text" name="keywords" value="<s:property value="keywords"/>" style="height: 15px"/>
			<input value="" type="hidden" name="page.p"/>
			<input value="<s:property value="page.totalPage"/>" type="hidden" name="totalPage"/>
			<input value="<s:property value="page.currentPage"/>" type="hidden" name="currentPage"/>
			<label class="ui-green"><input type="submit" name="search" value="搜索房屋" /></label>
		</form>
		<label class="ui-green" style="margin-top: 5px;"><input onclick="window.location.href = '${basePath}admin/addUI.do';" type="button" name="search" value="发布房屋信息" /></label>
		<label class="ui-green" style="margin-top: 5px;"><input type="button" onclick="window.location.href='${basePath}layout.do'" name="search" value="退       出" /></label>
	</div>
</div>
<div class="main wrap" style="margin-top: 50px;">
	<table class="house-list">
	<c:if test="${requestScope.houseList ne null}">
	<c:forEach items="${requestScope.houseList}" var="house" varStatus="status">
		<tr <c:if test="${status.count%2 == 0}">class="odd"</c:if>>
			<td class="house-thumb"><span><a href="${basePath}showUI.do?house.id=${house.id}"><img src="${basePath}images/thumb_house.gif" /></a></span></td>
			<td>
				<dl>
					<dt><a href="${basePath}showUI.do?house.id=${house.id}">${house.title}</a></dt>
					<dd>
						${house.streetByStreetId.districtByDistrictId.name}区${house.streetByStreetId.name},${house.floorage }平米<br />
						联系方式：${house.contact }	
					</dd>
				</dl>
			</td>
			<td class="house-type"></td>
			<td class="house-price">
				<label class="ui-green"><input type="button" onclick='updateById(${house.id})' name="search" value="修改" /></label>
				<label class="ui-green"  style="margin-left:5px; "><input type="button" onclick='deleteById(${house.id})' name="search" value="删除" /></label></td>
		</tr>
    </c:forEach>
    </c:if>   
  	<c:if test="${empty requestScope.houseList}">
    	<tr><c:out value="无租房信息"></c:out></tr> 
    </c:if>
	</table>
	<div class="pager">
		<ul>
			<li><a href="javascript:toPage('home');">首页</a></li>
			<li><a href="javascript:toPage('prePage');">上一页</a></li>
			<li><a href="javascript:toPage('nextPage');">下一页</a></li>
			<li><a href="javascript:toPage('end');">末页</a></li>
		</ul>
		<span class="total"><s:property value="page.currentPage"/>/<s:property value="page.totalPage"/>页</span>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
<script type="text/javascript">
	function toPage(flag) {
	    var currentPage = parseInt($("#gotoPage input[name='currentPage']").val());
	    var totalPage = parseInt($("#gotoPage input[name='totalPage']").val());
		if(flag == 'home'){
            gotoPage(1,totalPage);
		}else if (flag == 'prePage'){
            gotoPage(currentPage - 1,totalPage);
		}else if (flag == 'nextPage'){
            gotoPage(currentPage + 1,totalPage);
        }else if (flag == 'end'){
            gotoPage(totalPage,totalPage);
        }
    }
    function gotoPage(_pageIndex,_totalPage) {
        if(_pageIndex <= 0 || _pageIndex > _totalPage){
            alert("您要跳转的页码不存在");
            return;
        }
        var _url = "${basePath}admin/managerUI.do";
        var _form = $("#gotoPage");
        $("#gotoPage input[name='page.p']").val(_pageIndex);
        _form.attr("action",_url);
        _form.submit();
    }
    function deleteById(id) {
		baseAjax({
            url:"${basePath}admin/deleteHouse.do?house.id="+id,
            success : function(data) {
                window.location.reload();
            }
        });
    }
    function updateById(id) {
        var _url = "${basePath}admin/updateUI.do?house.id="+id;
       	window.location.href = _url;
    }
    
</script>
</body>
</html>


