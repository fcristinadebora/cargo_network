import java.util.ArrayList;

public class Vehicle {
  private String name;
  private int cargoCapacity = 0; // Challenge 2 - this attribute stores the cargo capacity of each vehicle
  private ArrayList<Cargo> carryingCargos = new ArrayList<Cargo>();
  private boolean inTransit = false;
  private Company company;

  public Vehicle(String name, int cargoCapacity, Company company) {
    this.name = name;
    this.cargoCapacity = cargoCapacity;
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
   * @return int return the cargoCapacity
   */
  public int getCargoCapacity() {
    return cargoCapacity;
  }

  /**
   * @param cargoCapacity the cargoCapacity to set
   */
  public void setCargoCapacity(int cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
  }

  /**
   * @return ArrayList<Cargo> return the carryingCargos
   */
  public ArrayList<Cargo> getCarryingCargos() {
    return carryingCargos;
  }

  /**
   * @param carryingCargos the carryingCargos to set
   */
  public void setCarryingCargos(ArrayList<Cargo> carryingCargos) {
    this.carryingCargos = carryingCargos;
  }

  /**
   * @return boolean return the inTransit
   */
  public boolean isInTransit() {
    return inTransit;
  }

  /**
   * @param inTransit the inTransit to set
   */
  public void setInTransit(boolean inTransit) {
    this.inTransit = inTransit;
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

  public void addCargo(Cargo cargo) {
    if(this.carryingCargos.size() >= this.cargoCapacity) {
      System.out.println(this.getName() + " of " + this.getCompany().getName() + " reached max cargo capacity of" + this.cargoCapacity);
      return;
    }

    System.out.println(this.getName() + " of " + this.getCompany().getName() + " is now carrying " + cargo.getCompanyName() + "," + cargo.getDescription() );
    this.carryingCargos.add(cargo);
  }
}