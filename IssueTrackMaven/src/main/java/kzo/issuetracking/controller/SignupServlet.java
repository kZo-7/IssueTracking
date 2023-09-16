package kzo.issuetracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kzo.issuetracking.dao.UserDao;
import kzo.issuetracking.model.UserModel;
import kzo.issuetracking.util.ServletUtil;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//forward the request to signup.jsp page
		//RequestDispatcher reqDisp = request.getRequestDispatcher(IssueTrackView.signupPage);
		//reqDisp.forward(request, response);
		ServletUtil.forward(IssueTrackView.signupPage, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Define operations after pressing the submit button on user's signup page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//create an obj of the UserModel class
		UserModel user = new UserModel();
		//set the values of user's attributes
		user.setName(request.getParameter("usName"));
		user.setSurname(request.getParameter("usSurname"));
		user.setPosition(request.getParameter("usPosition"));
		user.setEmail(request.getParameter("usEmail"));
		user.setPsw(request.getParameter("usPsw"));
		
		long i = UserDao.addUser(user);
		//if user added into DB
		if (i > 0) {
			ServletUtil.setSuccessMessage("Successful registration!", request);
			System.out.println(ServletUtil.getSuccessMessage(request));
			//redirect the user in index.jsp page after successful registration.
			request.getRequestDispatcher(IssueTrackView.indexPage).forward(request, response);
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			//ServletUtil.forward(IssueTrackView.indexPage, request, response);
		} else {
			ServletUtil.setErrorMessage("Registration failed :(. Try again.", request);
			System.out.println(ServletUtil.getErrorMessage(request));
			//redirect the user in index.jsp page after successful registration.
			request.getRequestDispatcher(IssueTrackView.signupPage).forward(request, response);
		}
		
	}

}