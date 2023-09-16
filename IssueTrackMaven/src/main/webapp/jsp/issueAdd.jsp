<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.controller.IssueTrackView" 
		import="kzo.issuetracking.model.UserModel"
		import= "java.util.List"
		import= "java.util.Iterator"
		import="kzo.issuetracking.util.ServletUtil"%>	

<!DOCTYPE html>
<html>

<head>
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
</head>

<body>
	<%@ include file="mainHeader.jsp"%>
	<%@ include file="sideMenu.jsp"%>

	<div class="main">
		<div class="issue">
			<div style="text-align: center; padding-top: 7vh; font-size: calc(0.5em + 2vw)">
				Add Issue
			</div>
			<form action="<%= IssueTrackView.issueAddServlet %>" method="post" style="padding-top: 5vh">
				<table style="">
					<tr>
						<th>Title</th>
						<td><input type="text" name="issTitle" placeholder="Enter a title" required /></td>
					</tr>
					<tr>
						<th>Desription</th>
						<td><input type="text" name="issDescr" placeholder="Give issue's description" required /></td>
					</tr>
					<tr>
						<th><label for="crBy">Created by</label></th>
						<td><input type="text" name="issCreatedBy" placeholder="Enter your id" required />
						</td>
					</tr>
					<tr>
						<th><label for="cat">Category</label></th>
						<td><select id="cat" name="issCat"
							style="width: 19.5vw; padding-left: 1vw">
								<option value="none" selected>Select Category</option>
								<option value="bug">bug</option>
								<option value="feature">feature</option>
								<option value="process">process</option>
						</select></td>
					</tr>
					<tr>
						<th><label for="prior">Priority</label></th>
						<td><select id="prior" name="issPrior"
							style="width: 19.5vw; padding-left: 1vw">
								<option value="0" selected>Select Priority (min: "1")</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
						</select></td>
					</tr>
					<tr>
						<th><label for="uat">User assigned to</label></th>
						<td><input type="text" name="issUsAssingTo" placeholder="Enter the name of appropriate user" required />
								<%-- <%
								int index = 0;
								List list = ServletUtil.getList(request);
								Iterator it = list.iterator();
								while (it.hasNext()) {
									UserModel user = (UserModel)it.next();
									out.println("<option value=\"" + user.getId() + "\">" + user.getName() + "</option>");
								%> 
								<%
									index++;
								}
                            %>  --%>
						</td>
					</tr>
					<tr>
						<th><label for="st">Status</label></th>
						<td><select id="st" name="issStatus"
							style="width: 19.5vw; padding-left: 1vw">
								<option value="-1" selected>Select status</option>
								<option value="new">new</option>
								<option value="in Progress">in progress</option>
								<option value="resolved">resolved</option>
						</select></td>
					</tr>
				</table>
				<br> <input type="submit" name="add" value="Add">
			</form>
			<%
			
			System.out.println(session.getAttribute("us_firstName")); 
			%>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>

</html>