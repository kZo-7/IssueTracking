package kzo.issuetracking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kzo.issuetracking.dao.IssueDao;
import kzo.issuetracking.dao.UserDao;
import kzo.issuetracking.model.IssueModel;
import kzo.issuetracking.model.UserModel;
import kzo.issuetracking.util.DataUtil;
import kzo.issuetracking.util.ServletUtil;

/**
 * Servlet implementation class IssueAddServlet
 */
@WebServlet(name = "IssueAddServlet", urlPatterns = { "/IssueAddServlet" })
public class IssueAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IssueAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * List list = null; UserDao user = new UserDao(); list = user.userlist();
		 * 
		 * if (list==null && list.size()==0) {
		 * ServletUtil.setErrorMessage("No User records in DB", request); }
		 * 
		 * ServletUtil.setList(list, request);
		 */
		ServletUtil.forward(IssueTrackView.issueAddPage, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// create an obj of the IssueModel class
		IssueModel issue = new IssueModel();

		// set the values of user's attributes
		issue.setTitle(request.getParameter("issTitle"));
		issue.setDescription(request.getParameter("issDescr"));
		issue.setCreatedBy(DataUtil.getInt(request.getParameter("issCreatedBy")));
		issue.setCategory(request.getParameter("issCat"));
		issue.setPriority(DataUtil.getInt(request.getParameter("issPrior")));
		issue.setAssignedTo(request.getParameter("issUsAssingTo"));
		issue.setStatus(request.getParameter("issStatus"));

		List list = null;
		long i = IssueDao.addIssue(issue);

		// if user added into DB
		if (i > 0) {
			ServletUtil.setSuccessMessage("Issue succesfully added to DB!", request);
			System.out.println(ServletUtil.getSuccessMessage(request));
			// redirect the user in index.jsp page after successful registration.
			request.getRequestDispatcher(IssueTrackView.mainAppPage).forward(request, response);
			// request.getRequestDispatcher("/index.jsp").forward(request, response);
			// ServletUtil.forward(IssueTrackView.indexPage, request, response);
		} else {
			ServletUtil.setErrorMessage("Something went wrong :( - Try again.", request);
			System.out.println(ServletUtil.getErrorMessage(request));
			// redirect the user in index.jsp page after successful registration.
			request.getRequestDispatcher(IssueTrackView.issueAddPage).forward(request, response);
		}
	}

}
