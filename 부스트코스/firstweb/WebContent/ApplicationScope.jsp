<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		int value = (int)application.getAttribute("value");
		
		value = value + 2;
		application.setAttribute("value", value);
%>
		<h1>value : <%=value %></h1>		
<%		
	}catch(Exception e){
		e.printStackTrace();
%>
		<h1>설정된 값이 없습니다.</h1>
<%
	}
%>	
</body>
</html>