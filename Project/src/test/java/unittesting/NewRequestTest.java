package unittesting;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.brian.dao.ReimbursementsDAOImpl;
import com.revature.brian.model.Reimbursements;

public class NewRequestTest {

	@InjectMocks
	private ReimbursementsDAOImpl rDao;
	
	@Mock
	private Reimbursements mockRequests;
	
	@Before
	public void setUp() {
		System.out.println("Before");
		
		MockitoAnnotations.initMocks(this);
		
		rDao = Mockito.mock(ReimbursementsDAOImpl.class);
		
		this.mockRequests =  new Reimbursements(null, 5, 1.00, "haha", "testing");

		}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void insertIntoReimbursements() {
		Mockito.when(this.rDao.insertIntoReimbursements(mockRequests)).thenReturn(true);

	}
}

