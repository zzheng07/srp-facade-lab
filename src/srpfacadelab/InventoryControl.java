package srpfacadelab;

import java.util.List;

public class InventoryControl {

  public boolean pickUpItem(IGameEngine game, RpgPlayer player, Item item) {
    List<Item> inventory = player.getInventory();

    int weight = calculateWeight(inventory);
    if (weight + item.getWeight() > player.getCarryingCapacity())
      return false;

    if (item.isUnique() && checkIfItemExists(inventory, item))
      return false;

    // Don't pick up items that give health, just consume them.
    if (item instanceof MedicalItem) {
      useMedicalItem(game, player, (MedicalItem) item);
      return true;
    }

    if (item.isRare() && item.isUnique()) {
      game.playSpecialEffect("blue_swirly");
    } else if (item.isRare() && !item.isUnique()) {
      game.playSpecialEffect("cool_swirly_particles");
    }

    inventory.add(item);

    if (item instanceof ArmourItem) {
      useArmour(player, (ArmourItem) item);
    }

    return true;
  }

  public void useItem(IGameEngine game, RpgPlayer player, Item item) {
    if (item.getName().equals("Stink Bomb")) {
      List<IEnemy> enemies = game.getEnemiesNear(player);

      for (IEnemy enemy : enemies) {
        enemy.takeDamage(100);
      }
    }
  }

  private void useMedicalItem(IGameEngine game, RpgPlayer player, MedicalItem item) {
    if (item.getHeal() > 0) {
      player.setHealth(player.getHealth() + item.getHeal());

      if (item.getHeal() > 500) {
        game.playSpecialEffect("green_swirly");
      }
    }
  }

  private void useArmour(RpgPlayer player, ArmourItem item) {
    List<Item> inventory = player.getInventory();
    int armour = 0;
    for (Item i : inventory) {
      if (i instanceof ArmourItem) {
        armour += ((ArmourItem) i).getArmour();
      }
    }

    player.setArmour(armour);
  }

  private boolean checkIfItemExists(List<Item> inventory, Item item) {
    for (Item i : inventory) {
      if (i.getId() == item.getId())
        return true;
    }
    return false;
  }

  private int calculateWeight(List<Item> inventory) {
    int sum = 0;
    for (Item i : inventory) {
      sum += i.getWeight();
    }
    return sum;
  }

}
