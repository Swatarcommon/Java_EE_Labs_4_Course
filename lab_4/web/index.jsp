<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.logging.Logger" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%
    Logger logger = Logger.getLogger("com.anexinet.sample");
    int hours = new Date().getHours();
    String name = "";
    if ( hours > 0 && hours < 6){
      out.println("Good night");
      logger.info("Good night");
      name = "night.jsp";
    }
    else if (hours > 6 && hours < 12) {
      out.println("Good morning");
      logger.info("Good morning");
      //name = "morning.jsp";
      name = "/afternoon";
    }
    else if (hours > 12 && hours < 18) {
      out.println("Good afternoon");
      logger.info("Good afternoon");
      name = "afternoon.jsp";
      //name = "/afternoon";
    }
    else if (hours > 18 && hours < 24) {
      out.println("Good  evening");
      logger.info("Good evening");
      name = "evening.jsp";
    }

    out.println("<br><br>");
    out.println("<table>");
    LocalDateTime localDateTime = LocalDateTime.now();
    for (int i = 0; i < 7; i++){
      LocalDateTime date = localDateTime.plusDays(i);
      out.println("<tr>");
      out.println("<td>"+date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"</td>");
      out.println("<td>"+date.getDayOfWeek().getValue()+"</td>");
      out.println("</tr>");
    }
    out.println("</table>");
  %>
  <br/>

<%--  <a href="<%= name%>"><input type="button" value="press"/></a>--%>
<%--  <%--%>
<%--    if(request.getParameter("submit1") != null) {--%>
<%--      switch(name){--%>
<%--        case "night.jsp":%><%@include file="night.jsp"%><%--%>
<%--        break;--%>
<%--      case "morning.jsp":%><%@include file="morning.jsp"%><%--%>
<%--        break;--%>
<%--      case "evening.jsp": %><%@include file="evening.jsp"%><%--%>
<%--        break;--%>
<%--      default :%><%@include file="afternoon.jsp"%><%--%>
<%--        break;--%>
<%--      }--%>
<%--    }--%>
<%--  %>--%>
  <%
    if(request.getParameter("submit1") != null) {
  %>
<%--  <jsp:include page="<%= name%>"/>--%>
  <jsp:forward page="<%= name%>"/>
  <%
    }
  %>
  <form>
    <input type="submit" name="submit1" value="press">
  </form>

  <form action="GoJjj" method="post">
    <input type="submit" value="GoJjj">
  </form>

  </body>
</html>
