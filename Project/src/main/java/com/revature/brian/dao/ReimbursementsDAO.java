package com.revature.brian.dao;

import java.util.List;

import com.revature.brian.model.Reimbursements;

public interface ReimbursementsDAO {
	public Reimbursements selectRequestById(Integer reimb_id);
	public List<Reimbursements> selectRequestsByEmployee(Integer emp_id);
	public Boolean insertIntoReimbursements (Reimbursements request);
	public List<Reimbursements> selectAllRequests();
	public Boolean updateReimbursements (Reimbursements req);
	
}
