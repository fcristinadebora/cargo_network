import java.util.ArrayList;

public class Location {
	private String name;
	private Company company;
	private ArrayList<Vehicle> waitingVehicles = new ArrayList<Vehicle>();
	private ArrayList<Cargo> waitingCargos = new ArrayList<Cargo>();
	private ArrayList<Route> routes = new ArrayList<Route>();

	public Location(String name, Company company) {
		this.name = name;
		this.company = company;
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

	/**
	 * @return Company return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	public static Location findLocationByName(ArrayList<Location> locationList, String name) {
		for (Location location : locationList) {
			if (location.getName().equals(name)) {
				return location;
			}
		}

		return null;
	}

	public void addWaitingVehicle(Vehicle vehicle) {
		this.waitingVehicles.add(vehicle);
	}

	public void removeWaitingVehicle(Vehicle vehicle) {
		this.waitingVehicles.remove(vehicle);
	}

	/**
	 * @return ArrayList<Vehicle> return the waitingVehicles
	 */
	public ArrayList<Vehicle> getWaitingVehicles() {
		return waitingVehicles;
	}

	/**
	 * @param waitingVehicles the waitingVehicles to set
	 */
	public void setWaitingVehicles(ArrayList<Vehicle> waitingVehicles) {
		this.waitingVehicles = waitingVehicles;
	}

	/**
	 * @return ArrayList<Cargo> return the waitingCargos
	 */
	public ArrayList<Cargo> getWaitingCargos() {
		return waitingCargos;
	}

	/**
	 * @param waitingCargos the waitingCargos to set
	 */
	public void setWaitingCargos(ArrayList<Cargo> waitingCargos) {
		this.waitingCargos = waitingCargos;
	}

	public void addWaitingCargo(Cargo cargo) {
		this.waitingCargos.add(cargo); // Add the cargo to the waiting cargos list
		System.out.println("New cargo from " + cargo.getCompanyName() + " at " + cargo.getStartingPlace().getName()
				+ " waiting for vehicle");
	}

	public void removeWaitingCargos(Cargo cargo) {
		this.waitingCargos.remove(cargo);
	}

	public Vehicle getAvailableVehicle() {
		if (this.waitingVehicles.isEmpty()) {
			return null;
		}

		return this.waitingVehicles.get(0);
	}

	public void addRoute(Route route) {
		this.routes.add(route);
	}

	
    /**
     * @return ArrayList<Route> return the routes
     */
    public ArrayList<Route> getRoutes() {
        return routes;
    }

    /**
     * @param routes the routes to set
     */
    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }

}