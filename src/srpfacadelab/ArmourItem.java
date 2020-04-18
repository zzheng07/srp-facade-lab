package srpfacadelab;

public class ArmourItem extends Item {

  // How much armour the player gets when it is equipped.
  private int armour;

  public ArmourItem(int id, String name, int weight, boolean unique, boolean rare, int armour) {
    super(id, name, weight, unique, rare);
    this.armour = armour;
  }

  public int getArmour() {
    return armour;
  }

}
