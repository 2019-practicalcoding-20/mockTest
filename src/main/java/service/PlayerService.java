package service;

import domain.Player;
import repository.PlayerRepository;

import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository mockPlayers) {
        this.playerRepository= mockPlayers;
    }

    public List<Player> showAllPlayers() {
        return playerRepository.showAll();
    }
    public Player findByName(String name) {
    	return playerRepository.findByPlayerName(name);
    }

    public Player findByPlayerNum(int playerNum)
    {
        Player player = playerRepository.findByPlayerNum(playerNum);
        return player;
    }

    public void addPlayer(Player player)
    {
        Player addPlayer = new Player(player.getName(), player.getPlayerNum(), player.getAge(), player.getGender(), player.getClanName());
        playerRepository.addPlayer(addPlayer);
        return;
    }


}
