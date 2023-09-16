<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.controller.IssueTrackView" %>	
    
<!DOCTYPE html>
<html>

<head>
	<title>Issue Tracking</title>
	<style>
        <%@include file="../css/styles.css" %>
    </style>
</head>

<body>
	<!-- <div class="mainHeaderTopNav">
    	<span class="nameApp">Issue Tracking</span>
	</div> -->
	<div class="topnav">
    	<a class="home" href="#"><%= session.getAttribute("us_firstname") %></a>
    	<span>Issue Tracking</span>
    	<a class="logout" href="<%= IssueTrackView.logoutServlet %>">Logout</a>
	</div>
</body>

</html>