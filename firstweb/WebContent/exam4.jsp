<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 주석 예제 -->

<!-- HTML 주석입니다. => JSP파일에서 JAVA파일로 변경되면서 out.write()로 내용이 남는다.-->
<%-- JSP 주석입니다. => JSP파일에서 JAVA파일로 변경되면서 내용은 남지 않는다. --%>
<%
// 자바 주석입니다. => JSP파일에서 JAVA파일로 변경되면서 내용은 남는다.
/* 자바 여러줄 주석입니다. */

	for(int i = 1; i <= 6; i++){
%>
		<h<%=i%>>아름다운 한글</h<%=i%>>
<%
	}
%>		
</body>
</html>