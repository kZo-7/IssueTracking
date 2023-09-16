package kzo.issuetracking.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
public class ServletUtil {
	static String Error = "Invalid data";
	static String SucessMessage = "Done";
	
	//Forward request
	public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		System.out.println(page);
		rd.forward(request, response);
	}
	
	//Redirect request 
	public static void redirect(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect(page);
	}
	
	//Handle Exception
	public static void handleException(Exception e, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("exception", e);
		ServletUtil.forward("Error Message", request, response);
		e.printStackTrace();
	}
	
	//get Error message
	public static String getErrorMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	//get the value of a message
	public static String getMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}
	
	//create our error messages
	public static void setErrorMessage(String msg, HttpServletRequest request) {
		//It's a pair value -> Key(Error) : value(msg)
		request.setAttribute(Error, msg);
	}
	
	//get the value of our error messages
	public static String getErrorMessage(HttpServletRequest request) {
		String val = (String) request.getAttribute(Error);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}
	
	//create our success messages
	public static void setSuccessMessage(String msg, HttpServletRequest request) {
		//It's a pair value -> Key(SucessMessage) : value(msg)
		request.setAttribute(SucessMessage, msg);
	}
	
	//get the value of our success messages
	public static String getSuccessMessage(HttpServletRequest request) {
		String val = (String) request.getAttribute(SucessMessage);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static String getParameter(String property, HttpServletRequest request) {
		String val = (String) request.getParameter(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setList(List list, HttpServletRequest request) {
		//It's a pair value -> Key("list") : value(list)
		request.setAttribute("list", list);
	}

	public static List getList(HttpServletRequest request) {
		return (List) request.getAttribute("list");
	}
	
	//When we have to do operations like save, edit, delete
	public static void setOperation(String msg, HttpServletRequest request) {
		//It's a pair value -> Key("Operation") : value(msg)
		request.setAttribute("Operation", msg);
	}

	public static String getOperation(HttpServletRequest request) {
		String val = (String) request.getAttribute("Operation");
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}
}
