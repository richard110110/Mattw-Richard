package asgn2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

import org.junit.Before;
import org.junit.Test;
import junit.*;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Customer> excepTest = new ArrayList<Customer>();
	
	@Before
	public void populateList() throws CustomerException, LogHandlerException{
			customers = LogHandler.populateCustomerDataset(".//logs/20170101.txt");
	}
	
	@Test
	public void testLineOneName(){		
		assertEquals(customers.get(0).getName(), "Casey Jones");
	}
	
	@Test
	public void testLineOneCustomerType(){		
		assertEquals(customers.get(0).getCustomerType(), "Driver Delivery");
	}
	
	@Test
	public void testLineOneLocationX(){		
		assertEquals(customers.get(0).getLocationX(), 5);
	}
	
	@Test
	public void testLineOneLocationY(){		
		assertEquals(customers.get(0).getLocationX(), 5);
	}
	
	@Test
	public void testLineOneMobileNumber(){		
		assertEquals(customers.get(0).getMobileNumber(), "0123456789");
	}
	//=======================================================================================
	
	//Test data set population worked for line 2 and 3=======================================
	@Test
	public void testLineTwo(){		
		assertEquals(customers.get(1).getName(), "April O'Neal");
		assertEquals(customers.get(1).getCustomerType(), "Drone Delivery");
		assertEquals(customers.get(1).getLocationX(), 3);
		assertEquals(customers.get(1).getLocationY(), 4);
		assertEquals(customers.get(1).getMobileNumber(), "0987654321");
	}
	
	@Test
	public void testLineThree(){		
		assertEquals(customers.get(2).getName(), "Oroku Saki");
		assertEquals(customers.get(2).getCustomerType(), "Pick Up");
		assertEquals(customers.get(2).getLocationX(), 0);
		assertEquals(customers.get(2).getLocationY(), 0);
		assertEquals(customers.get(2).getMobileNumber(), "0111222333");
	}

	@Test(expected = LogHandlerException.class)
	public void testPopulateCustomerDataSetException() throws CustomerException, LogHandlerException{
		excepTest = LogHandler.populateCustomerDataset("file.kj");
	}
	
	@Test(expected = LogHandlerException.class)
	public void testCreateCustomerException() throws CustomerException, LogHandlerException{
		excepTest.add(LogHandler.createCustomer(null));
	}
}
