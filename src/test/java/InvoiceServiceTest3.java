import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest3 {
	InvoiceGenerator3 invoiceGenerator1 = null;
	
	/*
	 * Creating invoice before test run
	 */
	@Before
	public void setUp() throws Exception {
		invoiceGenerator1 = new InvoiceGenerator3();
	}

	/*
	 * To Test Given Distance and Time Should Return total fare.
	 */
	@Test
	public void givenDistanceTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator1.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	/*
	 * To test given Distance or time should return MinimumFare
	 */
	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator1.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	/*
	 * To test given multiple rides should return total fare.
	 */
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride3[] rides = { 
				new Ride3(2.0, 5), new Ride3(0.1, 1) 
				};
         InvoiceSummary3 summary= invoiceGenerator1.calculateFare(rides);
		InvoiceSummary3 expectedInvoiceSummary = new InvoiceSummary3(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	/*
	 * To test given User Id should return the Invoice summary  of total rides
	 */
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {
		String userId = "ckpd@123";
		Ride3[] rides = { 
				new Ride3(2.0, 5), new Ride3(0.1, 1) 
				};
		invoiceGenerator1.addRide(userId, rides);
         InvoiceSummary3 summary= invoiceGenerator1.calculateFare(rides);
		InvoiceSummary3 expectedInvoiceSummary = new InvoiceSummary3(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}