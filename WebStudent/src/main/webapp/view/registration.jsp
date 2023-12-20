<!DOCTYPE html>
<html>
<head>
    
</head>
<body>
<hr>
<h4>Regiatration</h4>
<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>
        
<form action="/signup" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <input type="submit" value="Register">
</form>
    <h5><a href="http://localhost:8080/">RETURN</a></h5>    
</body>
</html>