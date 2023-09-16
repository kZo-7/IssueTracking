<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.controller.IssueTrackView" %>	

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Issue Tracking</title>
	<style>
        <%@include file="../css/styles.css" %>
    </style>
</head>

<body>
	<div class="sidenav">
    	<div class="dropdown-btn">
    		<h2 id="issueH2">Issues</h2>
    		<form action="<%= IssueTrackView.issueAddServlet %>" method="get" style="padding-top: 1vh;" >
    			<input class="sideInput" type="submit" name="add" value="Add">
    		</form>
    		<form action="<%= IssueTrackView.issueDelServlet %>" method="get" style="padding-top: 1vh">
    			<input class="sideInput" type="submit" name="delete" value="Delete">
    		</form>
    		<form action="<%= IssueTrackView.issueEditServlet %>" method="post" style="padding-top: 1vh">
    			<input class="sideInput" type="submit" name="edit" value="Edit">
    		</form>
    		<div class="loginUserID">
    			<h4>Your id is:</h4>
    			<%= session.getAttribute("us_id") %>
    		</div>
    	</div>
	</div>
</body>

</html>