package srpfacadelab;

public class SimpleEnemy implements IEnemy {

  private int health;
  private String name;

  public SimpleEnemy(String name) {
    this.name = name;
  }

  public void takeDamage(int amount) {
    // Meant to be the simplest.
    // Allowing negative health
    health -= amount;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

}
