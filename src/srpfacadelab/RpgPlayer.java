package srpfacadelab;

import java.util.ArrayList;
import java.util.List;

public class RpgPlayer {
  public static final int MAX_CARRYING_CAPACITY = 1000;

  private int health;

  private int maxHealth;

  private int armour;

  // How much the player can carry in pounds
  private int carryingCapacity;

  private List<Item> inventory;

  public RpgPlayer() {
    carryingCapacity = MAX_CARRYING_CAPACITY;
    inventory = new ArrayList<>();
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = Math.min(health, maxHealth);
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public void setMaxHealth(int maxHealth) {
    this.maxHealth = maxHealth;
  }

  public int getArmour() {
    return armour;
  }

  public void setArmour(int armour) {
    this.armour = armour;
  }

  public int getCarryingCapacity() {
    return carryingCapacity;
  }

  public List<Item> getInventory() {
    return inventory;
  }
}
