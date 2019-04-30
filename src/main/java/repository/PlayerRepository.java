package repository;

import domain.Player;

import java.util.List;

public interface PlayerRepository {
    List<Player> showAll();

    Player findByPlayerNum(int playerNum);
    Player findByPlayerName(String name);
    void addPlayer(Player player);

}
