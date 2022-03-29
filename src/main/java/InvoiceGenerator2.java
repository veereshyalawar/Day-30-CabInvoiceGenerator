public class InvoiceGenerator2 {
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
	public InvoiceSummary calculateFare(Ride2[] rides) {
		double totalFare = 0;
		for (Ride2 ride : rides) {
			totalFare = this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}