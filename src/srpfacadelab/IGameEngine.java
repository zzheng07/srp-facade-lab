package srpfacadelab;

import java.util.List;

public interface IGameEngine {

  public void playSpecialEffect(String effectName);

  List<IEnemy> getEnemiesNear(RpgPlayer player);

  public void addPlayer(RpgPlayer player);

}
