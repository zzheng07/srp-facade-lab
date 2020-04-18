package srpfacadelab;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

  private RpgPlayer player;
  private IGameEngine gameEngine;
  private List<Item> inventory;

  public Inventory(RpgPlayer player, IGameEngine gameEngine) {
    this.player = player;
    this.gameEngine = gameEngine;
    this.inventory = new ArrayList<>();
  }

  public boolean pickUpItem(Item item) {
    int weight = calculateWeight();
    if (weight + item.getWeight() > player.getCarryingCapacity())
      return false;

    if (item.isUnique() && checkIfItemExists(item))
      return false;

    // Don't pick up items that give health, just consume them.
    if (item instanceof MedicalItem) {
      player.useMedicalItem((MedicalItem) item);
      return true;
    }

    if (item.isRare() && item.isUnique()) {
      gameEngine.playSpecialEffect("blue_swirly");
    } else if (item.isRare() && !item.isUnique()) {
      gameEngine.playSpecialEffect("cool_swirly_particles");
    }

    inventory.add(item);

    if (item instanceof ArmourItem) {
      player.setArmour(calculateArmour());
    }

    return true;
  }

  public boolean checkIfItemExists(Item item) {
    for (Item i : inventory) {
      if (i.getId() == item.getId())
        return true;
    }
    return false;
  }

  private int calculateWeight() {
    int sum = 0;
    for (Item i : inventory) {
      sum += i.getWeight();
    }
    return sum;
  }

  private int calculateArmour() {
    int armour = 0;
    for (Item i : inventory) {
      if (i instanceof ArmourItem) {
        armour += ((ArmourItem) i).getArmour();
      }
    }
    return armour;
  }

}
