<%-- EL표기법을 인식하지 않고 텍스트로 인식하게 하고 싶을 때 --%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	request.setAttribute("k", 10); 
	request.setAttribute("m", true);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br> // k를 EL표현으로 사칙연산을 활용해보고고 출력해보자.
	k : ${k}<br>
	k + 5 = ${k + 5}<br>
	k - 5 = ${k - 5}<br>
	k * 5 = ${k * 5}<br>
	k / 5 = ${k div 5}<br>

	<br> // k를 EL표현으로 BOOLEAN을 활용해보고 출력해보자.
	k > 5 = ${k > 5}<br>
	k < 5 = ${k < 5}<br>
	k <= 10 = ${k <= 10}<br>
	k >= 10 = ${k >= 10}<br>
	
	<br> // m을 출력해보자.
	m : ${m}

</body>
</html>