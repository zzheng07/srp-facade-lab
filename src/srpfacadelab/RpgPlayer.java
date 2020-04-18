package srpfacadelab;

import java.util.List;

public class RpgPlayer implements IEnemy {
  public static final int MAX_CARRYING_CAPACITY = 1000;

  private final IGameEngine gameEngine;

  private int health;

  private int maxHealth;

  private int armour;

  private Inventory inventory;

  // How much the player can carry in pounds
  private int carryingCapacity;

  public RpgPlayer(IGameEngine gameEngine) {
    this.gameEngine = gameEngine;
    this.inventory = new Inventory(this, gameEngine);
    this.carryingCapacity = MAX_CARRYING_CAPACITY;
  }

  public void useItem(Item item) {
    if (item.getName().equals("Stink Bomb")) {
      List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

      for (IEnemy enemy : enemies) {
        enemy.takeDamage(100);
      }
    }
  }

  public void useMedicalItem(MedicalItem item) {
    if (item.getHeal() > 0) {
      health += item.getHeal();

      if (health > maxHealth)
        health = maxHealth;

      if (item.getHeal() > 500) {
        gameEngine.playSpecialEffect("green_swirly");
      }
    }
  }

  public boolean pickUpItem(Item item) {
    return inventory.pickUpItem(item);
  }

  public void takeDamage(int damage) {
    if (damage < armour) {
      gameEngine.playSpecialEffect("parry");
    }

    int damageToDeal = damage - armour;
    double percent = carryingCapacity < MAX_CARRYING_CAPACITY * 0.5 ? 0.75 : 1.0;
    health -= damageToDeal * percent;

    gameEngine.playSpecialEffect("lots_of_gore");
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
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
}
