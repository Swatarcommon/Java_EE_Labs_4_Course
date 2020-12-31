<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <a href="GoUrln">Check urln parameter</a><br>
  <a href="urlparam.jsp">Params url1 and url2</a>
  <br><br>
  <form action="GoCcc" method="post">
    Value1:<input type="text" name="Value1"><br><br>
    Value2:<input type="text" name="Value2"><br><br>
    Value3:<input type="text" name="Value3"><br><br>
    CBean: <div><input type="radio" name="CBean" value="new">new</div>
    <div><input type="radio" name="CBean" value="old">old</div>
    <input type="submit">
  </form>
  </body>
</html>
