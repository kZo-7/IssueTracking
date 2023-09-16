package kzo.issuetracking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kzo.issuetracking.dao.IssueDao;
import kzo.issuetracking.util.ServletUtil;

/**
 * Servlet implementation class MainAppServlet
 */
@WebServlet(name = "MainAppServlet", urlPatterns = {"/MainAppServlet"})
public class MainAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletUtil.forward(IssueTrackView.mainAppPage, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//store the value of input regarding the status of the issues we want to view
		String issueList = request.getParameter("issListStatus");
		//create the query
		
		IssueDao issue = new IssueDao();
		List list = null;		
		
		switch(issueList) {
		  case "new":
			System.out.println("new issues");
			String queryStatNew = "select * from issues where status=\"new\" order by priority asc";
			list = issue.list(queryStatNew);
		    break;
		  case "in progress":
			System.out.println("Issues in progress");
			String queryStatInProgr = "select * from issues where status=\"in progress\" order by priority asc";
			list = issue.list(queryStatInProgr);
		    break;
		  case "resolved":
			System.out.println("Resolved issues");
			String queryStatResolved = "select * from issues where status=\"in progress\" order by priority asc";
			list = issue.list(queryStatResolved);
			break;
		  default:
		    System.out.println("MainAppServlet -> entered default from switch case..");
		}
		
		if (list==null && list.size()==0) {
			ServletUtil.setErrorMessage("No Issue records in DB", request);
		}
		
		ServletUtil.setList(list, request);
	    ServletUtil.forward(IssueTrackView.viewIssues, request, response);
	}

}
