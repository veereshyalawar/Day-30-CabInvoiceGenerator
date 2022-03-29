import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository3 {
	
	/*
	 * Using Hashmap to create the RideRepository
	 */
	Map<String, ArrayList<Ride3>> userRides;
	public RideRepository3() {
		userRides = new HashMap<String, ArrayList<Ride3>>();
	}
	
	/*
	 * Adding the rides to Ride Repository
	 */
	public void addRide(String userId, Ride3[] rides) {
		ArrayList<Ride3> rideList = this.userRides.get(userId);
		if(rideList == null ) {
			this.userRides.put(userId, new ArrayList<Ride3>(Arrays.asList(rides)));
		}
	}

	/*
	 * To get the ride summary using user ID
	 */
	public Ride3[] getRide(String userId) {
		return this.userRides.get(userId).toArray(new Ride3[0]);
	}

}