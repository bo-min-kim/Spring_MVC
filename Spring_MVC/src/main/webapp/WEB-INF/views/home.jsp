<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!--  컨트롤러로 serverTime Model의 Key값을 불러왔음. -->
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
