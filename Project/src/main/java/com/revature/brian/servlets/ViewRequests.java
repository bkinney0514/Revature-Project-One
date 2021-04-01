package com.revature.brian.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.brian.dao.ReimbursementsDAOImpl;
import com.revature.brian.model.Reimbursements;

/**
 * Servlet implementation class ViewRequests
 */
public class ViewRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementsDAOImpl view = new ReimbursementsDAOImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		List<Reimbursements> requests = view.selectAllRequests();

		String success = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Company Manager Home</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Manager Home Page, Woo!</h1>\r\n"
				+ "<div>"
				+ "<h3>What would you like to do today?</h3>\r\n"
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
				+ "<br>\r\n"
				+ "<form action=\"ApproveDeny.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Approve or Deny a Request\"/>\r\n"
				+ "</form>\r\n"
				+ "<br/>\r\n"
				+ "<br/>\r\n"
				+ "<form action=\"HomePage.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Log Out\">\r\n"
				+ "</form>\r\n";
				
		out.print(success);
		for (Reimbursements r: requests) {
			out.print("Request ID: " + r.getReimb_id() + ", Employee ID: " + r.getEmp_id() + ", Amount: $" + r.getAmount() + ", Reason: " + r.getReason() + ", Status: " + r.getStatus()+"<br>");
		}
		out.print("</div>" + "</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
