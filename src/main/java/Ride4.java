public class Ride4 {
	/*
	 * Data to be used to calculate total fare
	 */
	public double distance;
	public int time;
	public RideCategories rideCategory;

	public Ride4(RideCategories rideCategory, double distance , int time) {
		this.distance = distance;
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}