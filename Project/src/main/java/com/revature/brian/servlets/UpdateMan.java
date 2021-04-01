package com.revature.brian.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.brian.dao.EmployeesDAOImpl;
import com.revature.brian.model.Employees;

/**
 * Servlet implementation class UpdateMan
 */
public class UpdateMan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		EmployeesDAOImpl update = new EmployeesDAOImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String emp_firstname = request.getParameter("first");
		String emp_lastname = request.getParameter("last");
		String emp_username = request.getParameter("username");
		String emp_password = request.getParameter("pass");
		
		String success = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Manager Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Manager Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
				+ "<h4>Your Information was successfully updated!</h4>"
				+ "<form action=\"viewman\" method=\"post\"> <!-- done -->\r\n"
				+ "<input type=\"submit\" value=\"View My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"UpdateManager.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Update My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"viewemps\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"View All Employees' Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"viewreqs\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"View All Reimbursement Requests\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"ApproveDeny.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Approve or Deny a Request\"/>\r\n"
				+ "</form>\r\n"
				+ "<br/>\r\n"
				+ "<br/>\r\n"
				+ "<form action=\"HomePage.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Log Out\">\r\n"
				+ "</form>\r\n"
				+ "</div>"
				+ "</body>";
		String invalid = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Manager Update</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Update My Information</h3>"
				+ "<div>"
				+ "<h4 style \"color: red\">An error occurred, please try again.</h4>"
				+ "<form action=\"updateMan\" method=\"post\">\r\n"
				+ "Please enter your new information as follows:\r\n"
				+ "<br>\r\n"
				+ "First Name: <input type=\"text\" name=\"first\">\r\n"
				+ "<br>\r\n"
				+ "Last Name: <input type=\"text\" name=\"last\">\r\n"
				+ "<br>\r\n"
				+ "Username: <input type=\"text\" name=\"username\">\r\n"
				+ "<br>\r\n"
				+ "Password: <input type=\"password\" name=\"pass\">\r\n"
				+ "<br>\r\n"
				+ "<input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"Manager.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Go Back\">\r\n"
				+ "</form>\r\n"
				+ "</div>"
				+ "</body>";
				
		Employees employee = new Employees(null, emp_firstname, emp_lastname, emp_username, emp_password, "Employee");
		employee = update.updateEmployees(username, employee);
		
		if (employee != null) {
			out.print(success);
		} else {
			out.print(invalid);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
