<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String bProfile= (String) session.getAttribute("user");%>
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
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
        <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign-up</a></li>
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
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
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
<div class="container">
  <h2>Login Form</h2>
   <form name="loginForm" action="Post" method="GET">
    <div class="form-group">
      <label for="username">Username: </label>
	  <input type="text" class="form-control" id="username" name= "username">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    <div class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="login" id="login">Submit</button>
 	<a class="btn btn-primary btn-md" href="index.jsp">Cancel</a>
	</div>
  </form>
</div> 
${content1}
</body>
</html>