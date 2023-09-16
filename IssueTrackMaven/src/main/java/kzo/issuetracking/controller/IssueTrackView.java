package kzo.issuetracking.controller;

//for managing Url's 
public interface IssueTrackView {

	public String APP_CONTEXT = "/IssueTrackMaven";
	public String JSP_FOLDER = "/jsp";

	public String indexPage = "/index.jsp";
	public String loginPage = JSP_FOLDER + "/login.jsp";
	public String signupPage = JSP_FOLDER + "/signup.jsp";
	public String mainAppPage = JSP_FOLDER + "/mainApp.jsp";
	public String viewIssues = JSP_FOLDER + "/viewByStatus.jsp";
	public String issueAddPage = JSP_FOLDER + "/issueAdd.jsp";
	public String issueDelPage = JSP_FOLDER + "/issueDel.jsp";
	public String issueEditPage = JSP_FOLDER + "/issueEdit.jsp";

	public String loginServlet = APP_CONTEXT + "/LoginServlet";
	public String logoutServlet = APP_CONTEXT + "/LogoutServlet";
	
	public String signupServlet = APP_CONTEXT + "/SignupServlet";
	
	public String mainAppServlet = APP_CONTEXT + "/MainAppServlet";
	
	public String issueAddServlet = APP_CONTEXT + "/IssueAddServlet";
	public String issueDelServlet = APP_CONTEXT + "/IssueDelServlet";
	public String issueEditServlet = APP_CONTEXT + "/IssueEditServlet";
}
