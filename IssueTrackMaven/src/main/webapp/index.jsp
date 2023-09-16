<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.controller.IssueTrackView"%>
<!DOCTYPE html>
<html>

<head>
<link rel="icon" href="./images/favicon.ico" type="image/x-icon">
<style>
<%@include file="css/styles.css" %>
</style>
</head>

<body>
	<%@ include file="jsp/loginHeader.jsp"%>
	<div class="signup">
		<h2>Welcome!</h2>

		<div class="signup">
			<table class="info">
				<tr>
					<th>Already a member</th>
					<td>:</td>
					<td class="indexTd"><a
						href="<%=IssueTrackView.loginServlet%>">Log In</a></td>
				</tr>
				<tr>
					<th>New blood?</th>
					<td class="indexTd">:</td>
					<td><a href="<%=IssueTrackView.signupServlet%>">Sign Up</a></td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="jsp/footer.jsp"%>
</body>
</html>
