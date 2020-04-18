package srpfacadelab;

public class MedicalItem extends Item {

  // How much the item heals by.
  private int heal;

  public MedicalItem(int id, String name, int weight, boolean unique, boolean rare, int heal) {
    super(id, name, weight, unique, rare);
    this.heal = heal;
  }

  public int getHeal() {
    return heal;
  }

}
