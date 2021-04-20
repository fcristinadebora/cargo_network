import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chris_scott_driver {
  private static ArrayList<Route> routeList = new ArrayList<Route>();
  private static ArrayList<Location> locationList = new ArrayList<Location>();
  private static ArrayList<Cargo> cargoList = new ArrayList<Cargo>();
  private static ArrayList<Cargo> activeCargos;
  public static void main(String[] args) {
    setupEntities();
    loadCargosFromParam(args[0]);
    loadRoutesFromParam(args[1]);

    int hour = 0;
    while((activeCargos  = Cargo.getEntryCargos(cargoList, hour)).size() > 0){
      System.out.println("\nTIME:" + hour + " __________ STATUS");
      for(Cargo currentCargo : activeCargos) {
        Location cargoLocation = currentCargo.getStartingPlace();
        
        cargoLocation.addWaitingCargo(currentCargo);
        cargoLocation.getCompany().handleLocationNewCargos(cargoLocation);
      }

      hour++;
    }

    
  }

  private static void loadCargosFromParam(String cargosCsv) {
    Cargo cargo;
    BufferedReader csvReader;
    String row;
    System.out.println("Reading cargos file...");
    try {
      csvReader = new BufferedReader(new FileReader(cargosCsv));
      while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        if(data[0].equals("Time")) {
          System.out.println("Skipping file header");
          continue;
        }

        int entryTime = Integer.parseInt(data[0].trim());
        String companyName = data[1].trim();
        String description = data[2].trim();
        String startingPlace = data[3].trim();
        String destination = data[4].trim();

        Location cargoStartLocation = Location.findLocationByName(locationList, startingPlace);
        if(cargoStartLocation == null) {
          System.out.println("Invalid StartingPlace " + startingPlace + " for line: " + row);
          continue;
        }
        Location cargoDestination = Location.findLocationByName(locationList, destination);
        if(cargoDestination == null) {
          System.out.println("Invalid Destination " + destination + " for line: " + row);
          continue;
        }

        cargo = new Cargo();
        cargo.setEntryTime(entryTime);
        cargo.setCompanyName(companyName);
        cargo.setDescription(description);
        cargo.setStartingPlace(cargoStartLocation);
        cargo.setDestination(cargoDestination);

        cargoList.add(cargo);
      }

      csvReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //I decided to setup Companies and their vehicles and locations manually
  private static void setupEntities() {
    //Declares auxiliar variables
    Vehicle vehicle;
    ArrayList<Vehicle> vehicleCollection;
    Company company;
    Location location;
    int companyCargoCapacity;

    //SETUP BLACK COMPANY
    company = new Company("Company Black"); //Instanciates the company
    companyCargoCapacity = 2;
    vehicleCollection = new ArrayList<Vehicle>(); //Reset vehicle collection
    
    //Create black company Locations and one vehicle for each location
    vehicle = new Vehicle("Vehicle1", companyCargoCapacity, company); //Instanciates new vehicle
    vehicleCollection.add(vehicle); //Push to vehicle list
    location = new Location("A", company); //Instanciates the location
    location.addWaitingVehicle(vehicle);
    locationList.add(location); //Push to locations list

    //Location B doesn't have a waiting vehicle
    location = new Location("B", company); //Instanciates the location
    locationList.add(location);
    
    vehicle = new Vehicle("Vehicle2", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("C", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location); 

    company.setVehicles(vehicleCollection);

    //SETUP BLUE COMPANY, almost the same as black company, repeat for other companies
    company = new Company("Company Blue");
    companyCargoCapacity = 3;
    vehicleCollection = new ArrayList<Vehicle>();

    //Create company Locations and waiting vehicles
    //Location D doesn't have a waiting vehicle
    location = new Location("D", company); //Instanciates the location
    locationList.add(location);
    
    vehicle = new Vehicle("Vehicle1", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("E", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    vehicle = new Vehicle("Vehicle2", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("F", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    vehicle = new Vehicle("Vehicle3", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("G", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    company.setVehicles(vehicleCollection);

    //setup RED company
    company = new Company("Company Red", true); //Challenge 1 - Company red allows visitant vehicles to wait at their sites
    companyCargoCapacity = 3;
    vehicleCollection = new ArrayList<Vehicle>();
    
    //Create company Locations and waiting vehicles
    vehicle = new Vehicle("Vehicle1", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("H", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    vehicle = new Vehicle("Vehicle2", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("J", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    location = new Location("K", company); //Instanciates the location
    locationList.add(location);

    company.setVehicles(vehicleCollection);

    //setup GREEN company
    company = new Company("Company Blue");
    companyCargoCapacity = 2;
    vehicleCollection = new ArrayList<Vehicle>();
    
    //Create company Locations and waiting vehicles
    location = new Location("L", company);
    locationList.add(location);

    vehicle = new Vehicle("Vehicle3", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("M", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    vehicle = new Vehicle("Vehicle2", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("N", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);
    
    vehicle = new Vehicle("Vehicle1", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("O", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);     

    vehicle = new Vehicle("Vehicle4", companyCargoCapacity, company);
    vehicleCollection.add(vehicle);
    location = new Location("P", company);
    location.addWaitingVehicle(vehicle);
    locationList.add(location);

    location = new Location("Q", company);
    locationList.add(location);

    location = new Location("R", company);
    locationList.add(location);    

    company.setVehicles(vehicleCollection);
  }

  private static void loadRoutesFromParam(String routesCsv) {
    BufferedReader csvReader;
    String row;
    System.out.println("Reading routes file...");
    try {
      csvReader = new BufferedReader(new FileReader(routesCsv));
      while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        if(data[0].equals("StartingLocation")) {
          System.out.println("Skipping file header");
          continue;
        }

        String inputStartingLocation = data[0].trim();
        String inputDestination = data[1].trim();
        float inputCost = Float.parseFloat(data[2].trim());
        float inputTime = Float.parseFloat(data[3].trim());

        Location startingLocation = Location.findLocationByName(locationList, inputStartingLocation);
        if (startingLocation == null) {
          System.out.println("Starting location " + inputStartingLocation + " not found for for line: " + row);
          continue;
        }
        Location destination = Location.findLocationByName(locationList, inputDestination);
        if (destination == null) {
          System.out.println("Destination " + inputDestination + " not found for for line: " + row);
          continue;
        }

        Route route = new Route(startingLocation, destination, inputCost, inputTime);
        startingLocation.addRoute(route);
        routeList.add(route);
      }

      csvReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}