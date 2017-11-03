<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 -发布房屋信息</title>
<link type="text/css" rel="stylesheet" href="${basePath}css/style.css" />
<script type="text/javascript" src="${basePath}scripts/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${basePath}scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${basePath}images/logo.gif" /></div>

</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<dl class="clearfix">
			<dt>新房屋信息发布</dt>
			<dd class="past">填写房屋信息</dd>

		</dl>
		<div class="box">
			<form action="${basePath}admin/addHouse.do" method="post" id="addHouse">
				<div class="infos">
					<table class="field">
						<tr>
							<td class="field">标　　题：</td>
							<td><input type="text" class="text" name="house.title" /></td>
						</tr>
						<tr>
							<td class="field">户　　型：</td>
							<td>
								<select id="add_type" class="text" name="house.typeId">
									<option value="1000">一室一厅</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="field">面　　积：</td>
							<td><input type="text" class="text" name="house.floorage" /></td>
						</tr>
						<tr>
							<td class="field">价　　格：</td>
							<td><input type="text" class="text" name="house.price" /></td>
						</tr>
                        <tr>
							<td class="field">位　　置：</td>
							<td>区：
								<select id="add_district" class="text" onchange="loadStreet(this)"></select>
                            	街：<select id="add_street" class="text" name="house.streetId"></select>
                            </td>
						</tr>
                        <tr>
							<td class="field">联系方式：</td>
							<td><input type="text" class="text" name="house.contact" /></td>
						</tr>
                        <tr>
							<td class="field">详细信息：</td>
							<td><textarea name="house.description"></textarea></td>
						</tr>
					</table>
					<div class="buttons"><input type="submit" name="submit" value="立即发布" /></div>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
<script>
	$(function () {
        //地区
        baseAjax(
            {
                url:"${basePath}admin/point/districtList.do",
                success : function(data) {
                    $('#add_district').html('');
                    for (var i = 0; i < data.length;i++){
                        $('#add_district').append('<option value="'+data[i].id+'">'+data[i].name  +'</option>');
                    }
                    if(data.length > 0){
                        var dom = document.getElementById("add_district");
                        dom.value = data[0].id;
                        loadStreet(dom);
                    }
                }
            }
        );
        //类型
        baseAjax(
            {
                url:"${basePath}admin/point/typeList.do",
                success : function(data) {
                    $('#add_type').html('');
                    for (var i = 0; i < data.length; i++){
                        $('#add_type').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
                    }
                }
            }
        );

        $("#addHouse").submit(
            function () {
                baseAjax(
					{
						url:"${basePath}admin/addHouse.do",
						data:$("#addHouse").serialize(),
                        success:function (data) {
							window.location.href = "${basePath}admin/managerUI.do";
                        }
					}
				);
                return false;
            }
		);

    });
    //联动
    function loadStreet(district){
        var _districtId = district.value;
        baseAjax(
            {
                url:"${basePath}admin/point/streetByDistrictId.do?districtId="+_districtId,
                success : function(data) {
                    $('#add_street').html('');
                    for (var i = 0; i < data.length; i++){
                        $('#add_street').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
                    }
                }
            }
        );
    }

</script>
</body>
</html>

