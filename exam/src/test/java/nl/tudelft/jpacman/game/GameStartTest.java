package nl.tudelft.jpacman.game;


import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GameStartTest {

    private SinglePlayerGame game;
    private Level level;

    @BeforeEach
    private void setUp() {
        level = mock(Level.class);
    }

    @Test
    @DisplayName("有豆子但没玩家存活，游戏结束")
    @Order(1)
    void testNoPlayerAlive() {

        when(level.isAnyPlayerAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(23);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("没有豆子没有玩家存活，游戏结束")
    @Order(2)
    void testNoPelletsNoPlayerAlive() {

        when(level.isAnyPlayerAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(0);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("有豆子且有玩家存活，游戏进行中")
    @Order(3)
    void testHasPelletsAndPlayerAlive() {

        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(23);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        game.start();

        assertThat(game.isInProgress()).isTrue();
    }

    @Test
    @DisplayName("没有豆子但有玩家存活，游戏结束")
    @Order(4)
    void testNoPelletsAndPlayrtAlive() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(0);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));

        game.start();

        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("游戏进行中再次调用start，状态不变")
    @Order(5)
    void testReStart() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(23);

        game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
        assertThat(game.isInProgress()).isFalse();

        game.start();
        assertThat(game.isInProgress()).isTrue();

        game.start();
        assertThat(game.isInProgress()).isTrue();

        verify(level, times(1)).isAnyPlayerAlive();
        verify(level, times(1)).remainingPellets();
    }

}
