package repository;

import java.util.List;
import domain.Player;

public interface PlayerRepository {
    List<Player> showAll();

    Player findByPlayerNum(int PlayerNum);
    Player findByPlayerName(String name);

    void addPlayer(Player Player);
}
