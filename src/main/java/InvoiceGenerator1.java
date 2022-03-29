
/**
 * The cab service is a subscription based cab service, where the customer books
 * a cab, and pays the bill at the end of the month.
 * 
 * UC1: Calculate Fare - Given Distance and time the invoice generator should
 * return the total fare of journey - Cost Rupees.10 per KM + Rupees.1 per minute. -
 * Minimum Fare - Rupees.5
 * 
 * @author user -Veeresh
 *
 */
public class InvoiceGenerator1 {
	/*
	 * Created constants given in the problems
	 */
	private static final double MINIMUM_COST_PER_KILOMETER = 10.00;
	private static final int COST_PER_TIME = 1;
	private static final int MINIMUM_FARE = 5;
	
	/*
	 * Method to calculate fare
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	/*
	 * Method to calculate total fare for multiple rides
	 */
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare = this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}
}