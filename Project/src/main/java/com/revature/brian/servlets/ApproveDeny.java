package com.revature.brian.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.brian.dao.ReimbursementsDAOImpl;
import com.revature.brian.model.Reimbursements;

/**
 * Servlet implementation class ApproveDeny
 */
public class ApproveDeny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveDeny() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementsDAOImpl update = new ReimbursementsDAOImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Integer reimb_id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		
		Reimbursements req = new Reimbursements(reimb_id, null, null, null, status);
		Boolean result = update.updateReimbursements(req);
		
		String success = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Manager Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Manager Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
				+ "<h4>Request successfully updated!</h4>"
				+ "<form action=\"viewman\" method=\"post\"> <!-- done -->\r\n"
				+ "<input type=\"submit\" value=\"View My Information\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"UpdateManager.html\" method=\"post\"> <!-- done -->\r\n"
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
				+ "<form action=\"SpecificEmployeeRequests.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"View One Employee's Requests\"/>\r\n"
				+ "</form>\r\n"
				+ "<br>"
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
		String invalid = "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Request Approval and Denial</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Approve or Deny Requests</h3>"
				+ "<div>"
				+ "<h4 style=\"color: red;\">An error occured, please try again.</h4>"
				+ "<form action=\"approvedeny\" method=\"post\">\r\n"
				+ "Please indicate the ID of the Reimbursement Request you would like to update: <input type=\"number\" name=\"id\">\r\n"
				+ "<br>\r\n"
				+ "Approved or Denied? <input type=\"text\" name=\"status\">\r\n"
				+ "<br> \r\n"
				+ "<input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"Manager.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Go Back\">\r\n"
				+ "</form>\r\n"
				+ "</div>"
				+ "</body>";
		
		if (result != false) {
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
