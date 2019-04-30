package service;

import domain.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import repository.PlayerRepository;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void testSavingPlayerAge(){
        Player player = mock(Player.class);
        player.setAge(25);
        verify(player).setAge(25);
    }

    @Test
    public void verifyTwiceTimes()
    {
        Player player1 = mock(Player.class);
        player1.getName();
        player1.getName();
        verify(player1, times(2)).getName();
    }


    @Test
    public void playerMockTest(){
        MockitoAnnotations.initMocks(this);
        assertTrue(playerRepository != null);
    }

    @Test
    public void verifySizeOfTheObject_ExecuteOnce(){
        List<Player> players = mock(ArrayList.class);

        Player player = mock(Player.class);
        player.setName("StarPlayer");
        player.setPlayerNum(100);
        player.setClanName("Mars");
        player.setGender("Male");
        player.setAge(20);

        players.add(player);

        int playerSize = players.size();
        verify(players, times(1)).size();

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIlligalArgumentExceptionWhenSetNameWithNull(){
        Player Player = mock(Player.class);

        doThrow(new IllegalArgumentException()).when(Player).setName(eq(null));
        Player.setName(null);
    }

    @Test
    public void mockPlayerServiceAndCallMethod() {
        when(playerService.findByName(anyString())).thenReturn(new Player("Player01", 0, 5,null,null));
        String championName = playerService.findByName("Player01").getName();
        assertThat(championName, Is.is("Player01"));
        verify(playerRepository, atMost(1)).findByPlayerName(anyString());
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