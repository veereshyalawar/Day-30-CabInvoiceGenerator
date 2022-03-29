
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
public class InvoiceGenerator {
	private static final double MINIMUM_COST_PER_KILOMETER = 10.00;
	private static final int COST_PER_TIME = 1;
	private static final int MINIMUM_FARE = 5;
	public double calculateFare(double distance,int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if(totalFare < MINIMUM_FARE)
		{
			return MINIMUM_FARE;
		}
		return totalFare;
	}
	
}