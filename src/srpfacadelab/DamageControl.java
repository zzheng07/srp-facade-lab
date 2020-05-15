package srpfacadelab;

public class DamageControl {

  public void takeDamage(IGameEngine game, RpgPlayer player, int damage) {
    if (damage < player.getArmour()) {
      game.playSpecialEffect("parry");
    }

    int damageToDeal = damage - player.getHealth();
    double carryingCapacity = player.getCarryingCapacity();
    double percent = carryingCapacity < RpgPlayer.MAX_CARRYING_CAPACITY * 0.5 ? 0.75 : 1.0;
    int newHealth = (int) (player.getHealth() - damageToDeal * percent);
    player.setHealth(newHealth);

    game.playSpecialEffect("lots_of_gore");
  }

}
