
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="login">
            
            <div> 
                <label> Username: </label>
                <input type="text" name="username" value="${username}">
            </div>
            
            <div> 
                <label> Password: </label>
                <input type="password" name="password" value="${password}">
            </div>
            
            <input type="submit" value="Log in">
        </form>
            <div>${message}</div>
    </body>
</html>
