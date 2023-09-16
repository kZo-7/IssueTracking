<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.controller.IssueTrackView" %>	
<!DOCTYPE html>
<html>

<head>
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
</head>
 
<body>
<%@ include file="loginHeader.jsp" %>
	<div class="signup">
		<h2>User Signup</h2>		
		
		<form action="<%= IssueTrackView.signupServlet %>" method="post">
			<div class="signup">
    			<table class="info">
      				<tr>
        				<th>Name</th>
        				<td>:</td>
        				<td><input name="usName" type="text" required></td>
      				</tr>
      				<tr>
        				<th>Surname</th>
        				<td>:</td>
        				<td><input name="usSurname" type="text" required></td>
      				</tr>
      				<tr>
        				<th>Position</th>
        				<td>:</td>
        				<td>
        					<label for="usPosition"></label>
							<input list="position" id="usPosition" name="usPosition" type="text" required>
							<datalist id="position">
  								<option value="Admin">Admin</option>
  								<option value="Debugger">Debugger</option>
  								<option value="Tester">Tester</option>
  								<option value="Employee">Employee</option>
							</datalist>
        				</td>
      				</tr>
      				<tr>
        				<th>Email</th>
        				<td>:</td>
        				<td><input name="usEmail" type="text" required></td>
      				</tr>
      				<tr>
        				<th>Password</th>
        				<td>:</td>
        				<td><input name="usPsw" type="password" required></td>
      				</tr>
      				<tr>
        				<th></th>
        				<td></td>
        				<td id="submitInput"><input type="submit" value="Sign Up"></td>
      				</tr>
    			</table>
    		</div>
		</form>
		<div class="signup">
			<table class="info">
      			<tr>
        			<th class="existOrNoUserRow">Have already an account?</th>
        			<td class="existOrNoUserCell"><a href="<%=IssueTrackView.loginServlet %>">Log In!</a></td>
      			</tr>
      		</table>
      	</div>	
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>
