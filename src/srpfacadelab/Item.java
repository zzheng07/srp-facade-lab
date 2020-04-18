package srpfacadelab;

public class Item {

  private int id;

  private String name;

  // How much this item weighs in pounds.
  private int weight;

  // A unique item can only be picked up once.
  private boolean unique;

  // Rare items are shiny
  private final boolean rare;

  public Item(int id, String name, int weight, boolean unique, boolean rare) {
    this.id = id;
    this.name = name;
    this.weight = weight;
    this.unique = unique;
    this.rare = rare;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public boolean isUnique() {
    return unique;
  }

  public void setUnique(boolean unique) {
    this.unique = unique;
  }

  public boolean isRare() {
    return rare;
  }
}
