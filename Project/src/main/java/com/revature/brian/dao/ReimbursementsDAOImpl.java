package com.revature.brian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.brian.connectionutil.ConnectionUtility;

import com.revature.brian.model.Reimbursements;

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	public static Logger log = LogManager.getLogger(EmployeesDAOImpl.class);

	@Override
	public Reimbursements selectRequestById(Integer reimb_id) {
		log.info("selectRequestById invoked");
		Reimbursements request = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.reimbursements WHERE reimb_id=?");
			ps.setInt(1, reimb_id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				request = new Reimbursements(
						rs.getInt(1),
						rs.getInt(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return request;
	}
	
	@Override
	public List<Reimbursements> selectRequestsByEmployee(Integer emp_id) {
		log.info("selectRequestsByEmployee invoked for Employee ID " + emp_id);
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Reimbursements> requests = new ArrayList<Reimbursements>();
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.reimbursements WHERE emp_id=?");
			ps.setInt(1, emp_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reimbursements reimb = new Reimbursements();
				reimb.setReimb_id(rs.getInt(1));
				reimb.setEmp_id(rs.getInt(2));
				reimb.setAmount(rs.getDouble(3));
				reimb.setReason(rs.getString(4));
				reimb.setStatus(rs.getString(5));
				
				requests.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return requests;
	}
	

	@Override
	public Boolean insertIntoReimbursements(Reimbursements request) {
		log.info("insertIntoReimbursements invoked by current Employee");
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO ers.reimbursements VALUES(DEFAULT, ?, ?, ?, ?)");

			ps.setInt(1, request.getEmp_id());
			ps.setDouble(2, request.getAmount());
			ps.setString(3, request.getReason());
			ps.setString(4, "Pending");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Reimbursements> selectAllRequests() {
		log.info("selectAllRequests invoked by Manager");
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Reimbursements> requests = new ArrayList<Reimbursements>();
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM ers.reimbursements";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Reimbursements request = new Reimbursements();
				request.setReimb_id(rs.getInt(1));
				request.setEmp_id(rs.getInt(2));
				request.setAmount(rs.getDouble(3));
				request.setReason(rs.getString(4));
				request.setStatus(rs.getString(5));
				
				requests.add(request);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return requests;
	}


	@Override
	public Boolean updateReimbursements(Reimbursements req) {
		log.info("updateReimbursements invoked by Manager");

		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE ers.reimbursements SET status=? WHERE reimb_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, req.getStatus());
			ps.setInt(2, req.getReimb_id());
			
			if (ps.executeUpdate() == 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
