import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest1 {
	InvoiceGenerator1 invoiceGenerator1 = null;
	
	/*
	 * Creating invoice before test run
	 */
	@Before
	public void setUp() throws Exception {
		invoiceGenerator1 = new InvoiceGenerator1();
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
	public void givenMultipleRides_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = invoiceGenerator1.calculateFare(rides);
		Assert.assertEquals(30, fare, 0.0);
	}
}