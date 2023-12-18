<!DOCTYPE html>
<html>
<head>
    
</head>
<body>
<hr>
<h4>Regiatration</h4>
<form action="/signup" method="post">
    Email: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Sign up"/>
</form>
    <h5>IF REGISTERED - <a href="http://localhost/login">SIGN IN</a></h5>    
</body>
</html>