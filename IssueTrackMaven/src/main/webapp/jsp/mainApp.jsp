<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
			<h2>View Issues</h2>
			<div class="issue-container">
				<form class="issueForm" action="<%=IssueTrackView.mainAppServlet%>" method="post">
					<div class=boxBtn>
						<div class="colDiv">
							<label for="issListStatus">Select filter </label>
						</div>
						<div class="colDiv">
							<input list="issuesListStat" id="issListStatus"
								name="issListStatus" type="text" required />
							<datalist id="issuesListStat">
								<option value="new"></option>
								<option value="in progress"></option>
								<option value="resolved"></option>
							</datalist>
						</div>
						<div class="colDiv">
							<input type="submit" value="Load">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>

</html>