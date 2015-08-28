<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sign-up</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="jquery.rateyo.css"/>
  
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Welcome to Bullhorn!</a>
    </div>
  </div>
</nav>
<div class="container">
<form action= "NewUser" method= "POST">
	<div class="form-group">
	  <label for="username">Username: </label>
	  <input type="text" class="form-control" id="username" name= "username">
	</div>
	<div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name= "password">
    </div>  
    <div class="form-group">
	  <label for="fname">Fullname: </label>
	  <input type="text" class="form-control" id="fname" name= "fname">
	</div>
	<div class="form-group">
	  <label for="motto">Motto: </label>
	  <input type="text" class="form-control" id="motto" name= "motto">
	</div>
 	<div class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="submit" id="submit">Submit</button>
 	<a class="btn btn-primary btn-md" href="index.jsp">Cancel</a>
	</div> 
   </form>
</div>
</body>
</html>
