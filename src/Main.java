import srpfacadelab.IGameEngine;
import srpfacadelab.Item;
import srpfacadelab.MedicalItem;
import srpfacadelab.RpgPlayer;
import srpfacadelab.RpgPlayerFacade;
import srpfacadelab.SimpleGameEngine;

public class Main {

  public static void main(String[] args) {
    // This is meant to be simple and just show how you could instantiate the structure

    IGameEngine game = new SimpleGameEngine();
    RpgPlayerFacade rpgPlayerFacade = new RpgPlayerFacade(game);

    RpgPlayer player1 = new RpgPlayer();
    RpgPlayer player2 = new RpgPlayer();
    game.addPlayer(player1);
    game.addPlayer(player2);

    // Here you would create items
    Item eneryDrink = new MedicalItem(0, "Energy Drink", 1, true, true, 500);
    Item stinkBomb = new Item(1, "Stink Bomb", 1, false, false);

    // Here you would tell the history and make the game happen
    rpgPlayerFacade.takeDamage(player1, 100);

    // You could make players pick up items
    boolean pickedUp = rpgPlayerFacade.pickUpItem(player1, stinkBomb);
    if (pickedUp) {
      rpgPlayerFacade.useItem(player1, stinkBomb);
    }

    rpgPlayerFacade.pickUpItem(player1, eneryDrink);
    // You could make players use items
    // etc.
    // You don't need to worry about it for the assignment
    // This is only to show how the 'external world' would instantiate the structure.
    // In the assignment, you're supposed to improve the design and not instantiate a game
  }
}
