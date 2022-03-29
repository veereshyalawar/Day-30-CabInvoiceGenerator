public enum RideCategories {
	/*
	 * Created constants of two categories of rides
	 */
	NORMAL_RIDE(10.0,1,5.0), PREMIUM_RIDE(15.0,2,20);
	
	public final double costPerKm;
	public final int costPerTime;
	public final double minFare;
	private RideCategories(double costPerKm, int costPerTime, double minFare) {
		this.costPerKm = costPerKm;
		this.costPerTime = costPerTime;
		this.minFare = minFare;
	}
	
	/*
	 * Method to calculate total fare for both category 
	 */
	public double calculateFare(Ride4 ride)
	{
		return Math.max((ride.getDistance() * costPerKm) + (ride.getTime() * costPerTime), minFare);
	}
}
