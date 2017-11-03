<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>错误页面</title>
    <link rel="stylesheet" type="text/css" href="${basePath}css/errorStyle.css" />
</head>
<body style="background:#0186a7;">
<div class="error_new_bg pr">
    <div class="error_new_content">
        <div class="error_new pa">
            <div class="fl error_new_left"><img src="${basePath}images/error.png"></div>
            <div class="fl error_new_right">
                <div class="error_detail">
                    <p class="error_p_title">哎呦~ 老司机居然累倒了!</p>
                    <p class="error_p_con">※ 别急，工程师正在紧急处理，马上就好。</p>
                </div>
                <p class="error_new_right_btn pr">
                    <a href="${basePath}admin/mainUI.do" class="type-2 type-3">
                        <i> 返回首页</i>
                        <i> 返回首页 </i>
                        <i> 返回首页 </i>
                        <i> 返回首页 </i>
                    </a>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
