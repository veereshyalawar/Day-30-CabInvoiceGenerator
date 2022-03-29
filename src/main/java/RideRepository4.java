import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository4 {
	
	/*
	 * Using Hashmap to create the RideRepository
	 */
	Map<String, ArrayList<Ride4>> userRides;
	public RideRepository4() {
		userRides = new HashMap<String, ArrayList<Ride4>>();
	}
	
	/*
	 * Adding the rides to Ride Repository
	 */
	public void addRide(String userId, Ride4[] rides) {
		ArrayList<Ride4> rideList = this.userRides.get(userId);
		if(rideList == null ) {
			this.userRides.put(userId, new ArrayList<Ride4>(Arrays.asList(rides)));
		}
	}

	/*
	 * To get the ride summary using user ID
	 */
	public Ride4[] getRide(String userId) {
		return this.userRides.get(userId).toArray(new Ride4[0]);
	}

}