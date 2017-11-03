<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="common/base.jsp"%>
<%response.setHeader("Pragma","No-cache"); %>
<%response.setHeader("Cache-Control","no-cache"); %>
<%response.setHeader("Expires","0");%>
<%
	String url = basePath + "index.do";
	response.sendRedirect(url);
%>