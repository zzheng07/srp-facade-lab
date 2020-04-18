import srpfacadelab.IGameEngine;
import srpfacadelab.Item;
import srpfacadelab.MedicalItem;
import srpfacadelab.RpgPlayer;
import srpfacadelab.SimpleGameEngine;

public class Main {

  public static void main(String[] args) {
    // This is meant to be simple and just show how you could instantiate the structure

    IGameEngine game = new SimpleGameEngine();
    RpgPlayer player1 = new RpgPlayer(game);
    RpgPlayer player2 = new RpgPlayer(game);
    game.addPlayer(player1);
    game.addPlayer(player2);

    // Here you would create items
    Item eneryDrink = new MedicalItem(0, "Energy Drink", 1, true, true, 500);
    player1.pickUpItem(eneryDrink);

    Item stinkBomb = new Item(1, "Stink Bomb", 1, false, false);
    player1.useItem(stinkBomb);

    // Here you would tell the history and make the game happen

    // You could make players pick up items
    // You could make players use items
    // etc.
    // You don't need to worry about it for the assignment
    // This is only to show how the 'external world' would instantiate the structure.
    // In the assignment, you're supposed to improve the design and not instantiate a game
  }
}
