package service;


import domain.Player;
import repository.PlayerRepository;

import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository mockPlaysers) {
        this.playerRepository= mockPlaysers;
    }

    public List<Player> showAllPlaysers() {
        return playerRepository.showAll();
    }

    public Player findByPlayserNum(int PlayerNum)
    {
        Player playser = playerRepository.findByPlayerNum(PlayerNum);
        return playser;
    }

    public void addPlayer(Player player)
    {
        Player addPlayer = new Player(player.getName(), player.getPlayerNum(), player.getAge(), player.getGender(), player.getClanName());
        playerRepository.addPlayer(addPlayer);
        return;
    }


}
