package srpfacadelab;

public class RpgPlayerFacade {
  private IGameEngine game;
  private DamageControl damageControl;
  private InventoryControl inventoryControl;

  public RpgPlayerFacade(IGameEngine _game) {
    game = _game;
    damageControl = new DamageControl();
    inventoryControl = new InventoryControl();
  }

  public void takeDamage(RpgPlayer player, int damage) {
    damageControl.takeDamage(game, player, damage);
  }

  public boolean pickUpItem(RpgPlayer player, Item item) {
    return inventoryControl.pickUpItem(game, player, item);
  }

  public void useItem(RpgPlayer player, Item item) {
    inventoryControl.useItem(game, player, item);
  }

}
