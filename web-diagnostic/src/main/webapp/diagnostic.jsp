<%@ page import="java.util.*" %>
<html>
<head>
<title>Diagnostic</title>
<style>
table {
border: solid 1px #000000;
border-collapse: collapse;
}
td {
border: solid 1px #000000;
padding: 0.2rem;
}
</style>
</head>
<body>
<h1>HTTP Request</h1>
<table>
<tr><td>URL</td><td><%=request.getRequestURL()%></td></tr>
<tr><td>Query String</td><td><%=request.getQueryString()%></td></tr>
<tr><td>Scheme</td><td><%=request.getScheme()%></td></tr>
<tr><td>Protocol</td><td><%=request.getProtocol()%></td></tr>
<tr><td>Server Host</td><td><%=request.getServerName()%></td></tr>
<tr><td>Server Port</td><td><%=request.getServerPort()%></td></tr>
<tr><td>Remote Address</td><td><%=request.getRemoteAddr()%></td></tr>
<tr><td>Remote Port</td><td><%=request.getRemotePort()%></td></tr>
<tr><td>Local Address</td><td><%=request.getLocalAddr()%></td></tr>
<tr><td>Local Port</td><td><%=request.getLocalPort()%></td></tr>
</table>
<h2>Request Headers</h2>
<table>
<%
Enumeration enumeration = request.getHeaderNames();
while (enumeration.hasMoreElements()) {
String name = (String) enumeration.nextElement();
String value = request.getHeader(name);
%>
<tr><td><%= name %></td><td><%= value %></td></tr>
<%
}
%>
</table>
</body>
</html>
