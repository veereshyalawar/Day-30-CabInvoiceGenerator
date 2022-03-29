
public class InvoiceSummary3 {

	/**
	 * Data for generating Invoice
	 */
	private final double averageFare;
	private final double totalFare;
	private final int numOfRides;

	public InvoiceSummary3(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare;
	}
	/*
	 * written equals method as we have given assertEquals in Test Class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary3 other = (InvoiceSummary3) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (numOfRides != other.numOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}
	
}