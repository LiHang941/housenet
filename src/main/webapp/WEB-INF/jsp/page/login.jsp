<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 用户登录</title>
	<link type="text/css" rel="stylesheet" href="${basePath}/css/style.css" />
	<script type="text/javascript" src="${basePath}/scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${basePath}/images/logo.gif" /></div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<h4>用户登录</h4>
			<form action="${basePath}login.do" method="post">
				<div class="infos">				
					<table class="field">
						<tr>
							<td></td>
							<td colspan="2" style="color: red"><s:property value="msg"/></td>
						</tr>
						<tr>
							<td class="field">用 户 名：</td>
							<td>
								<input type="text" class="text" name="user.username" />
							</td>
						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td>
								<input type="password" class="text" name="user.password" />
							</td>
						</tr>						
					</table>
					<div class="buttons"><input type="submit" value="立即登录"/></div>
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
</body>
</html>


