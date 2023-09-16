package kzo.issuetracking.controller;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kzo.issuetracking.dao.UserDao;
import kzo.issuetracking.model.UserModel;
import kzo.issuetracking.util.ServletUtil;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// forward the request to login.jsp page using our ServletUtil class
		ServletUtil.forward(IssueTrackView.loginPage, request, response);
		//Actually the above line is the same with creating a DispatcherRequest and forward our request
		//through it 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel user = new UserModel();
		//create a session for the particular user
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		user = UserDao.UserLogin(email, password);
		System.out.println("User's email is : " + email);
		if (user != null) {
			ServletUtil.setSuccessMessage("Successful login!", request);
			System.out.println("Success Msg : " + ServletUtil.getSuccessMessage(request));
			
			//set attributes for session
			session.setAttribute("us_id", user.getId());
			session.setAttribute("us_firstname", user.getName());
			session.setAttribute("us_lastname", user.getName());
			session.setAttribute("us_position", user.getPosition());
			session.setAttribute("us_email", user.getEmail());
			
			ServletUtil.redirect(IssueTrackView.mainAppServlet, request, response);
			//request.getRequestDispatcher(IssueTrackView.mainAppServlet).forward(request, response);
			//request.getRequestDispatcher("/sjp/mainApp.jsp").forward(request, response);
		} else {
			System.out.println("Login failed. Try again.");
			ServletUtil.setErrorMessage("Wrong email or password. Try again", request);
			System.out.println("Error Msg : " + ServletUtil.getErrorMessage(request));
			ServletUtil.forward(IssueTrackView.loginPage, request, response);
		}
	}

}
