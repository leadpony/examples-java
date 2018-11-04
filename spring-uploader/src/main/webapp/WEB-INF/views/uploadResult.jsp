<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Upload Result</title>
</head>
<body>
<h1>File Uploaded</h1>
<p>
<c:out value="${filename}"/> (<c:out value="${size}"/>)
</p>
</body>
</html>