<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String bProfile= (String) session.getAttribute("user");%>
<head>
  <title>Index</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<% if (bProfile == null || bProfile.equals("")) { %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Welcome to Bullhorn!</a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Sign-up.jsp"><span class="glyphicon glyphicon-user"></span> Sign-up</a></li>
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        <li><form name=ViewBulls action="ViewBulls" method="POST">
		<div class="form-group">
 		<button type="submit" class="glyphicon glyphicon-folder-open" name="submit" id="submit">View Bullhorns</button>
		</div> 
		</form></li>
      </ul>
    </div>
  </div>
</nav>

<% } else { %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Welcome to Bullhorn!</a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.jsp"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        <li><form name=ViewBulls action="ViewBulls" method="POST">
		<div class="form-group">
 		<button type="submit" class="glyphicon glyphicon-folder-open" name="submit" id="submit">View Bullhorns</button>
		</div> 
		</form></li>
      </ul>
    </div>
  </div>
</nav>
<% } %>

</body>
</html>
