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
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
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
		
		session.setAttribute("username", emp_username);
		
		String success = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Employee Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Employee Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
				+ "<h4>Your Information was successfully updated!</h4>"
				+ "<br>"
				+ "<form action=\"viewme\" method=\"post\"> <!-- done -->\r\n"
				+ "<input type=\"submit\" value=\"View My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"UpdateEmp.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Update My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"viewmine\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"View My Reimbursement Requests\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"SubmitRequest.html\" method=\"post\"> <!-- done -->\r\n"
				+ "<input type=\"submit\" value=\"Submit a Reimbursement Request\"/>\r\n"
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
				+ "<title>Employee Update</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Update My Information</h3"
				+ "<div>"
				+ "<h4 style=\"color: red\">An error occurred, please try again.</h4>"
				+ "<form action=\"updateEmp\" method=\"post\">\r\n"
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
				+ "<form action=\"EmployeeHome.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Go Back\">\r\n"
				+ "</form>"
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
