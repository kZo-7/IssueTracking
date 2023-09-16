<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="kzo.issuetracking.util.ServletUtil"
		import= "java.util.List"
		import= "java.util.Iterator"
		import= "kzo.issuetracking.model.IssueModel" %>	

<!DOCTYPE html>
<html>

<head>
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
</head>

<body>
<%@ include file="mainHeader.jsp" %>
<%@ include file="sideMenu.jsp" %>

	<div class="main">
		<div class="issueList">
			<h2>Issues by Status</h2>			
			<div class=boxBtn>
				<h4>
					<%= ServletUtil.getErrorMessage(request)%>
      			</h4> 
				<table id="issueList" class="tableIssueList">
					<thead class="tableIssueList">
						<tr class="tableIssueList">
							<th class="tableIssueList" scope="col">Id</th>
							<th class="tableIssueList" scope="col">Title</th>
							<th class="tableIssueList" scope="col">Description</th>
							<th class="tableIssueList" scope="col">Category</th>
							<th class="tableIssueList" scope="col">Priority</th>
							<th class="tableIssueList" scope="col">Assigned To</th>
							<th class="tableIssueList" scope="col">Date Created</th>
							<th class="tableIssueList" scope="col">Created By</th>
							<th class="tableIssueList" scope="col">Date Edited</th>
							<th class="tableIssueList" scope="col">Edited By</th>
							<th class="tableIssueList" scope="col">Status</th>
						</tr>
					</thead>
					<tbody >
<%
	int index = 1;
	List list = ServletUtil.getList(request);
	Iterator it = list.iterator();
	while (it.hasNext()) {
		IssueModel issue = (IssueModel)it.next();
%>
						<tr class="tableIssueList">
							<td class="tableIssueList" scope="row"><%= issue.getId() %></td>
							<td class="tableIssueList"><%= issue.getTitle() %></td>
							<td class="tableIssueList"><%= issue.getDescription() %></td>
							<td class="tableIssueList"><%= issue.getCategory() %></td>
							<td class="tableIssueList"><%= issue.getPriority() %></td>
							<td class="tableIssueList"><%= issue.getAssignedTo() %></td>
							<td class="tableIssueList"><%= issue.getDateCreated() %></td>
							<td class="tableIssueList"><%= issue.getCreatedBy() %></td>
							<td class="tableIssueList"><%= issue.getDateEdited() %></td>
							<td class="tableIssueList"><%= issue.getEditedBy() %></td>
							<td class="tableIssueList"><%= issue.getStatus() %></td>
						</tr>
<% } %>
					</tbody>
				</table>
			</div>
			<div id="backElem">
				<a href="<%= IssueTrackView.mainAppServlet %>">Back</a>
			</div>
		</div>
	</div>
	
<%@ include file="footer.jsp" %>
</body>

</html>