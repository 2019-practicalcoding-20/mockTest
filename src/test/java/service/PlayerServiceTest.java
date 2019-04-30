package service;

import domain.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.PlayerRepository;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.Is;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest{
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void whenBringPlayerName_returnRiot(){
        Player player = mock(Player.class);
        when(player.getName()).thenReturn("Riot");
        assertThat(player.getName(), Is.is("Riot"));
    }

    @Test
    public void whenBringPlayerNum_haveToReturnZero(){
        Player player = mock(Player.class);

        when(player.getPlayerNum()).thenReturn(0);
        assertThat(player.getPlayerNum(), Is.is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIlligalArgumentExceptionWhenSetNameWithNull(){
        Player Player = mock(Player.class);

        doThrow(new IllegalArgumentException()).when(Player).setName(eq(null));
        Player.setName(null);
    }

    @Test
    public void verifySizeOfThePlayer_ExecuteOnce(){
        List<Player> players = mock(ArrayList.class);

        Player player = mock(Player.class);
        player.setName("player01");
        player.setPlayerNum(1);
        player.setClanName("clan01");
        player.setGender("F");
        player.setAge(99);

        players.add(player);

        int championSize = players.size();
        verify(players,times(1)).size();
    }
    @Test
    public void whenSearchPlayer01_returnAge0() {
        when(playerService.findByName("Player01")).thenReturn(new Player("Player01",	0,0,null,null));
        Player player = playerService.findByName("Player01");
        assertThat(player.getAge(), Is.is(0));
    }
    @Test
    public void verifyFindByNameCalled() {
        //given
        given(playerRepository.findByPlayerName("Player01")).willReturn(new Player("Player01",0,0,null,null));
        //when
        Player player = playerService.findByName("Player01");
        //then
        verify(playerRepository, atLeast(1)).findByPlayerName(anyString());
        assertThat(player.getName(), Is.is("Player01"));
    }
}