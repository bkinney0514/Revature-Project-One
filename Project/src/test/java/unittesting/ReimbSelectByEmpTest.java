package unittesting;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.revature.brian.dao.ReimbursementsDAOImpl;

import com.revature.brian.model.Reimbursements;

public class ReimbSelectByEmpTest {

	@InjectMocks
	private ReimbursementsDAOImpl rDao;
	
	@Mock
	private List<Reimbursements> mockRequests;
	
	@Before
	public void setUp() {
		System.out.println("Before");
		
		MockitoAnnotations.initMocks(this);
		
		rDao = Mockito.mock(ReimbursementsDAOImpl.class);
		
		this.mockRequests =  new ArrayList<Reimbursements>();
		mockRequests.add(new Reimbursements(1,2,50.00,"because", "pending"));
		mockRequests.add(new Reimbursements(4,18,500000000.00,"because", "approved"));	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void selectRequestsByEmployee() {
		Mockito.when(this.rDao.selectRequestsByEmployee(18)).thenReturn(this.mockRequests);

	}
}
