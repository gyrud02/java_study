<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("p1", "page scope value");
	request.setAttribute("r1", "request scope value");
	session.setAttribute("s1", "session scope value");
	application.setAttribute("a1", "application scope value");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	pageContext.getAttribute("p1") : <%=pageContext.getAttribute("p1")%> <br>
	request.getAttribute("r1") : <%=request.getAttribute("r1") %> <br>
	session.getAttribute("s1") : <%=session.getAttribute("s1") %> <br>
	application.getAttribute("a1") : <%=application.getAttribute("a1") %> <br>
	
	// 위 자바코드를 EL표기법으로 변경해보자
	pageContext.getAttribute("p1") : ${pageScope.p1} <br>	
	request.getAttribute("r1") : ${requestScope.r1}<br>
	session.getAttribute("s1") : ${sessionScope.s1}<br>
	application.getAttribute("a1") : ${application.a1}<br>
	
	// EL표기법을 더 간단하게 사용할 수 있다.
	pageContext.getAttribute("p1") : ${p1} <br>	
	request.getAttribute("r1") : ${r1}<br>
	session.getAttribute("s1") : ${s1}<br>
	application.getAttribute("a1") : ${a1}<br>
	
</body>
</html>