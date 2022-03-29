import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest4 {
	InvoiceGenerator4 invoiceGenerator1 = null;

	/*
	 * Creating invoice before test run
	 */
	@Before
	public void setUp() throws Exception {
		invoiceGenerator1 = new InvoiceGenerator4();
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
		Ride4[] rides = { new Ride4(RideCategories.NORMAL_RIDE,2.0, 5), new Ride4(RideCategories.NORMAL_RIDE,0.1, 1) };
		InvoiceSummary4 summary = invoiceGenerator1.calculateFare(rides);
		InvoiceSummary4 expectedInvoiceSummary = new InvoiceSummary4(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	/*
	 * To test given User Id should return the Invoice summary of total rides
	 */
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {
		String userId = "ckpd@123";
		Ride4[] rides = { new Ride4(RideCategories.NORMAL_RIDE, 2.0, 5),
				new Ride4(RideCategories.NORMAL_RIDE, 0.1, 1) };
		invoiceGenerator1.addRide(userId, rides);
		InvoiceSummary4 summary = invoiceGenerator1.calculateFare(rides);
		InvoiceSummary4 expectedInvoiceSummary = new InvoiceSummary4(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	/*
	 * Given Ride Categories should return the invoice summary
	 */
	@Test
	public void givenTwoCategoriesOfRides_ShouldReturnTheInvoiceSummary() {
		String userId = "chandra@123";
		Ride4[] rides = { new Ride4(RideCategories.NORMAL_RIDE, 2.0, 5), new Ride4(RideCategories.NORMAL_RIDE, 0.1, 1),
				new Ride4(RideCategories.PREMIUM_RIDE, 0.1, 1) };
		invoiceGenerator1.addRide(userId, rides);
		InvoiceSummary4 summary = invoiceGenerator1.getInvoiceSummary(userId);
		InvoiceSummary4 expectedInvoiceSummary = new InvoiceSummary4(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}