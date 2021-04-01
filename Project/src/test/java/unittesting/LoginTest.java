package unittesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.brian.dao.EmployeesDAOImpl;
import com.revature.brian.model.Employees;

public class LoginTest {

	@InjectMocks
	private EmployeesDAOImpl eDao;
	
	@Mock
	private Employees mockEmployees;
	
	@Before
	public void setUp() {
		System.out.println("Before");
		
		MockitoAnnotations.initMocks(this);
		
		eDao = Mockito.mock(EmployeesDAOImpl.class);
		
		this.mockEmployees = new Employees();
		mockEmployees.add(new Employees(null, "First","Last","username","password","title"));
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void getEmployeeByLogin() {
		Mockito.when(this.eDao.getEmployeeByLogin("username", "password")).thenReturn(this.mockEmployees);
		
	}
}
