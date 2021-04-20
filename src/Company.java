import java.util.ArrayList;

public class Company {
	private String name;
	private boolean allowVisitantVehiclesWaiting = false; // Challenge 1 - by default, companies doesn't allow any vehicles
																										// waiting in its sites
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public Company(String name) {
		this.name = name;
	}

	public Company(String name, boolean allowVisitantVehiclesWaiting) {
		this.name = name;
		this.allowVisitantVehiclesWaiting = allowVisitantVehiclesWaiting;
	}

	/**
	 * @return String return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public boolean isAllowVisitantVehiclesWaiting() {
		return this.allowVisitantVehiclesWaiting;
	}

	public boolean getAllowVisitantVehiclesWaiting() {
		return this.allowVisitantVehiclesWaiting;
	}

	public void setAllowVisitantVehiclesWaiting(boolean allowVisitantVehiclesWaiting) {
		this.allowVisitantVehiclesWaiting = allowVisitantVehiclesWaiting;
	}
	
	/**
	 * @return ArrayList<Vehicle> return the vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void handleLocationNewCargos(Location location) {
		Vehicle vehicle = location.getAvailableVehicle();

		if(vehicle == null){
			System.out.println("No vehicle at location " + this.getName());
			return;
		}

		System.out.println(vehicle.getName() + " from " + vehicle.getCompany().getName() + " is available");
		Cargo cargo = location.getWaitingCargos().get(0);
		vehicle.addCargo(cargo);

		PathFinder pathFinder = new PathFinder();
		pathFinder.findPath(location, cargo.getDestination());
	}
}