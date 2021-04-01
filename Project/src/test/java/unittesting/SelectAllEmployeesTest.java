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

import com.revature.brian.dao.EmployeesDAOImpl;
import com.revature.brian.model.Employees;

public class SelectAllEmployeesTest {

	@InjectMocks
	private EmployeesDAOImpl eDao;
	
	@Mock
	private List<Employees> mockEmployees;
	
	@Before
	public void setUp() {
		System.out.println("Before");
		
		MockitoAnnotations.initMocks(this);
		
		eDao = Mockito.mock(EmployeesDAOImpl.class);
		
		this.mockEmployees =  new ArrayList<Employees>();
		mockEmployees.add(new Employees(5, "First","Last","username","password","title"));
		mockEmployees.add(new Employees(17, "FName","LName","user","pass","standing"));
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void selectAllEmployees() {
		Mockito.when(this.eDao.selectAllEmployees()).thenReturn(this.mockEmployees);
		
	}
}
