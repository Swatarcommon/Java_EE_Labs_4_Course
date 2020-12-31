<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String url1 = config.getServletContext().getInitParameter("url1");
    String url2 = config.getServletContext().getInitParameter("url2");
    out.println("URL1: "+url1);
    out.println("<br>");
    out.println("URL2: "+url2);
%>

</body>
</html>
