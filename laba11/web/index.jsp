<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <script type="text/javascript" src="scripts/script.js"></script>
  <script type="text/javascript"> var req = crReq();</script>
  <form>
    <p>
      <h4>Task1</h4>
      X:<input id="x" type="number" min="0" max="1000"><br><br>
      Y:<input id="y" type="number" min="0" max="1000"><br><br>
      Z:<input id="z" disabled="disabled"><br><br>
      <input type="button" value="Send" onclick="Post()">
    </p>
    <p>
      <h4>Task2</h4>
      <input id="n" type="number" min="1" max="1000">
      <h4 id="xml"></h4>
      <input type="button" value="Send" onclick="XmlPost()">
    </p>
    <p>
      <h4>Task3</h4>
      <input id="nj" type="number" min="1" max="1000">
      <h4 id="json"></h4>
      <input type="button" value="Send" onclick="JsonPost()">
    </p>
  </form>
  </body>
</html>
