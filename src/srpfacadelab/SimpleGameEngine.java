package srpfacadelab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGameEngine implements IGameEngine {

  private List<IEnemy> enemies;
  private List<RpgPlayer> players;
  private Map<String, String> effectMap;

  public SimpleGameEngine() {
    enemies = new ArrayList<IEnemy>();
    enemies.add(new SimpleEnemy("Creeper"));
    enemies.add(new SimpleEnemy("Zombie"));
    enemies.add(new SimpleEnemy("Golem"));

    players = new ArrayList<RpgPlayer>();

    effectMap = new HashMap<>();
    effectMap.put("green_swirly", "Green Swirl!!!");
    effectMap.put("cool_swirly_particles", "Fancy Swirly Particles in the air!!!");
    effectMap.put("parry", "Nop! Try better next time!");
    effectMap.put("lots_of_gore", "Ouch!! That hurts!!");
    effectMap.put("blue_swirly", "Rare and Unique Item.");
  }

  @Override
  public void addPlayer(RpgPlayer player) {
    players.add(player);
  }

  @Override
  public void playSpecialEffect(String effectName) {
    if (effectMap.containsKey(effectName)) {
      System.out.println("[Special Effect]: " + effectMap.get(effectName));
    }
  }

  @Override
  public List<IEnemy> getEnemiesNear(RpgPlayer player) {
    // Meant to be the simplest logic
    if (players.get(0).equals(player))
      return enemies; // First player got all enemies

    // Other players got none
    return null;
  }
}
