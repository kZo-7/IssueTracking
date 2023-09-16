<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.controller.IssueTrackView" %>	
<%@page import="kzo.issuetracking.util.ServletUtil" %>	
<!DOCTYPE html>
<html>

<head>
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
</head>

<body>
<%@ include file="loginHeader.jsp" %>
	<div class="login">
		<h2>User Login</h2>

		<form action="<%= IssueTrackView.loginServlet %>" method="post">
			<div class="login">
    			<table class="tableInfo">
      				<tr>
        				<th>Email</th>
        				<td>:</td>
        				<td><input name="email" type="text"/></td>
      				</tr>
      				<tr>
        				<th>Password</th>
        				<td>:</td>
        				<td><input name="psw" type="password"/></td>
      				</tr>
      				<tr>
        				<th></th>
        				<td></td>
        				<td id="loginInput"><input type="submit" value="Login"></td>
      				</tr>
    			</table>
    		</div>
		</form>
		<div class="login">
			<table class="tableInfo">
      			<tr>
        			<th class="existOrNoUserRow">Are you a fresh blood?</th>
        			<td class="existOrNoUserCell"><a href="<%=IssueTrackView.signupServlet %>">Sign Up!</a></td>
      			</tr>
      		</table>
      	</div>	
      	<div class="login">
      		<h4>
      			<%= ServletUtil.getErrorMessage(request)%>
      		</h4>
      	</div>
	</div>
<%@ include file="footer.jsp" %>
</body>

</html>