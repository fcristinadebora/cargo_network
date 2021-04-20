import java.util.ArrayList;
import java.util.Collections;

public class PathFinder {
  public ArrayList<Location> checkedLocations;
  public ArrayList<Route> path;

  public PathFinder() {
    this.path = new ArrayList<Route>();
    this.checkedLocations = new ArrayList<Location>();
  }

  public ArrayList<Route> findPath(Location from, Location to){
    System.out.println("Looking for path from " + from.getName() + " to " + to.getName());
    this.lookNeighbours(from, to);

    Collections.reverse(this.path);
    
    if(this.path.size() > 0) {
      System.out.println("found destination, route size: " + this.path.size() + " visited destinations: " + this.checkedLocations.size());
    }else{
      System.out.println("route not found");
    }
    for(Route route : this.path) {
      System.out.print(route.getStartingLocation().getName() + " to " + route.getDestination().getName() + " > ");
		}

    System.out.println("\n");

    return this.path.size() > 0 ? this.path : null;
  }

  private boolean lookNeighbours(Location location, Location destination){
    if(isLocationChecked(location)) {
      return false;
    }

    for(Route route : location.getRoutes()) {
      // System.out.print("Checkling route " + route.getStartingLocation().getName() + " to " + route.getDestination().getName());
      Location routeDestination = route.getDestination();

      if(routeDestination.equals(destination)) {
        System.out.print("// Found\n");
				path.add(route);
				return true;
			}

      this.checkedLocations.add(location);

      System.out.print("// Not found, looking in the neighbours\n");
      if(this.lookNeighbours(routeDestination, destination)) {
        path.add(route);
        System.out.println("Founddd");
        return true;
      }
		}

    System.out.println("Founddd");
    return false;
  }

  private boolean isLocationChecked(Location location){
    for(Location checked : checkedLocations) {
      if(checked.equals(location)) {
				return true;
			}
		}

    return false;
  }
}