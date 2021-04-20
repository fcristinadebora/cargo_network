public class Route {
  private Location startingLocation;
  private Location destination;
  private float cost;
  private float time;

  public Route(Location startingLocation, Location destination, float cost, float time) {
    this.startingLocation = startingLocation;
    this.destination = destination;
    this.cost = cost;
    this.time = time;
  }

  /**
   * @return float return the cost
   */
  public float getCost() {
    return cost;
  }

  /**
   * @param cost the cost to set
   */
  public void setCost(float cost) {
    this.cost = cost;
  }

  /**
   * @return float return the time
   */
  public float getTime() {
    return time;
  }

  /**
   * @param time the time to set
   */
  public void setTime(float time) {
    this.time = time;
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

    /**
     * @return Location return the startingLocation
     */
    public Location getStartingLocation() {
        return startingLocation;
    }

    /**
     * @param startingLocation the startingLocation to set
     */
    public void setStartingLocation(Location startingLocation) {
        this.startingLocation = startingLocation;
    }

}