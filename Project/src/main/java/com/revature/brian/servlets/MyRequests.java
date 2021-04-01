package com.revature.brian.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class MyRequests
 */
public class MyRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emp_username = (String) session.getAttribute("username");
		
		ReimbursementsDAOImpl view = new ReimbursementsDAOImpl();
		EmployeesDAOImpl eDao = new EmployeesDAOImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Employees employee = eDao.selectEmployees(emp_username);
		
		Integer emp_id = employee.getEmp_id();

		List<Reimbursements> requests = view.selectRequestsByEmployee(emp_id);

		String success = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Employee Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Employee Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
				+ "<form action=\"MyInfo.html\" method=\"post\"> <!-- done -->\r\n"
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
				+ "<br>\r\n"
				+ "<h4>My Requests: </h4>";

		out.print(success);
		for (Reimbursements r: requests) {
			out.print("Request ID: " + r.getReimb_id() + ", Employee ID: " + r.getEmp_id() + ", Amount: $" + r.getAmount() + ", Reason: " + r.getReason() + ", Status: " + r.getStatus()+"<br>");
		}
		out.print("</div></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
