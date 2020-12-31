<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import= "classes.*" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  Index <br>
  <a href="GoSss">GoSss</a>
  <%
    String d = (String) config.getServletContext().getInitParameter("filesDir");
    Choise ch = new Choise(d, "docx");
    String ll = null;
    for (int i = 0; i < ch.list.length; i++) {
      ll = ch.list[i];
  %>
  <br>
  <a href="GoSss?file=<%=ll%>"> <%=ll%> </a>
  <%}%>
  </body>
</html>
