public class InvoiceGenerator3 {
	/*
	 * @author -Veeresh
	 * Created constants given in the problems
	 */
	private static final double MINIMUM_COST_PER_KILOMETER = 10.00;
	private static final int COST_PER_TIME = 1;
	private static final int MINIMUM_FARE = 5;
	RideRepository3 rideRepository = new RideRepository3();
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
	public InvoiceSummary3 calculateFare(Ride3[] rides) {
		double totalFare = 0;
		for (Ride3 ride : rides) {
			totalFare = this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary3(rides.length, totalFare);
	}
	
	/*
	 * Method to add every ride to the RideRepository class
	 */
	public void addRide(String userId, Ride3[] rides) {
		rideRepository.addRide(userId, rides);
		
	}
	
	/*
	 * Method to get the calculated fare for every ride
	 */
	public InvoiceSummary3 getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRide(userId));
		
	}
}