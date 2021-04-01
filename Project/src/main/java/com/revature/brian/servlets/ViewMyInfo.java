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
 * Servlet implementation class ViewMyInfo
 */
public class ViewMyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String emp_username = (String) session.getAttribute("username");
		
		EmployeesDAOImpl view = new EmployeesDAOImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Employees employee = new Employees();
		employee = view.selectEmployees(emp_username);
		
		int emp_id = employee.getEmp_id();
		String firstname = employee.getEmp_firstname();
		String lastname = employee.getEmp_lastname();
		String username = employee.getEmp_username();
		String password = employee.getEmp_password();
		String title = employee.getEmp_title();

		String var = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Employee Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Employee Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
				+ "<form action=\"viewme\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"View My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>"
				+ "<h4>My Info: </h4>"
				+ "Employee ID: " + emp_id + "<br>"
				+ "Name: " + firstname +" " + lastname + "<br>"
				+ "Username: " + username + "<br>"
				+ "Password: " + password + "<br>"
				+ "Title: " + title + "<br>"
				+ "<br>"
				+ "<form action=\"UpdateEmp.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Update My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>"
				+ "<form action=\"viewmine\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"View My Reimbursement Requests\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>"
				+ "<form action=\"SubmitRequest.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Submit a Reimbursement Request\"/>\r\n"
				+ "</form>\r\n"
				+ "<br/>\r\n" 
				+ "<br/>\r\n"
				+ "\r\n"
				+ "<form action=\"HomePage.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Log Out\">\r\n"
				+ "</form>\r\n"
				+ "</div>"
				+ "</body>";

			out.print(var);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
