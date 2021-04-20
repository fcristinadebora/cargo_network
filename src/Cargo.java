import java.util.ArrayList;

public class Cargo {
  private int entryTime;
  private String companyName;
  private String description;
  private Location startingPlace;
  private Location destination;

  /**
   * @return String return the companyName
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * @param companyName the companyName to set
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  /**
   * @return String return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return Location return the startingPlace
   */
  public Location getStartingPlace() {
    return startingPlace;
  }

  /**
   * @param startingPlace the startingPlace to set
   */
  public void setStartingPlace(Location startingPlace) {
    this.startingPlace = startingPlace;
  }


  /**
   * @return int return the entryTime
   */
  public int getEntryTime() {
    return entryTime;
  }

  /**
   * @param entryTime the entryTime to set
   */
  public void setEntryTime(int entryTime) {
    this.entryTime = entryTime;
  }


    /**
     * @return Location return the destination
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Location destination) {
        this.destination = destination;
    }


    public static ArrayList<Cargo> getEntryCargos(ArrayList<Cargo> cargoList, int hour) {
      ArrayList<Cargo> activeCargos = new ArrayList<Cargo>();
      
      for( Cargo cargo : cargoList) { 
        if (cargo.getEntryTime() == hour) {
          activeCargos.add(cargo);
        }
      }
        
      return activeCargos;
    }
}