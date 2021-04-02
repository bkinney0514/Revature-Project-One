package com.revature.brian.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.brian.dao.EmployeesDAOImpl;
import com.revature.brian.dao.ReimbursementsDAOImpl;
import com.revature.brian.model.Employees;
import com.revature.brian.model.Reimbursements;

/**
 * Servlet implementation class SubmitRequest
 */
public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		EmployeesDAOImpl eDao = new EmployeesDAOImpl();
		Employees employee = eDao.selectEmployees(username);
		
		ReimbursementsDAOImpl submit = new ReimbursementsDAOImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Integer emp_id = employee.getEmp_id();
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String reason = request.getParameter("reason");
		
		Integer reimb_id = null;
		String status = "Pending";
		
		Reimbursements requests = new Reimbursements(reimb_id, emp_id, amount, reason, status);
		Boolean result = submit.insertIntoReimbursements(requests);
		
		String success = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Employee Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Employee Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
				+ "<h4>Your request was successfully submitted!"
				+ "<form action=\"viewne\" method=\"post\"> <!-- done -->\r\n"
				+ "<input type=\"submit\" value=\"View My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"UpdateEmp.html\" method=\"post\"> <!-- done -->\r\n"
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
				+ "<title>Request Form</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Reimbursement Request Form</h3>\r\n"
				+ "<div>"
				+ "<h4 sytle=\"color: red\">An error occurred, please try again.</h4>"
				+ "<form action=\"submitrequest\" method=\"post\">\r\n"
				+ "Please Enter The Amount You Would Like Reimbursed:<input type=\"text\" name=\"amount\"/>\r\n"
				+ "<br/>\r\n"
				+ "Please Enter Your Reason For This Request:<input type=\"text\" name=\"reason\"/>\r\n"
				+ "<br/>\r\n"
				+ "<input type=\"submit\" value=\"Submit My Request\"/>\r\n"
				+ "</form>\r\n"
				+ "<br/>\r\n"
				+ "<br/>\r\n"
				+ "<form action=\"EmployeeHome.html\" method=\"post\">\r\n"
				+ "<input type=\"Submit\" value=\"Go Back\">\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "</div>"
				+ "</body>";
		if(result != false) {
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
