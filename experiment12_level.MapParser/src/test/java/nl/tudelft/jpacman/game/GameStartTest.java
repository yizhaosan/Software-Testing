package nl.tudelft.jpacman.game;


import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        game.start();
        assertThat(game.isInProgress()).isTrue();

        game.start();
        assertThat(game.isInProgress()).isTrue();

        verify(level, times(1)).isAnyPlayerAlive();
        verify(level, times(1)).remainingPellets();
    }

/*
    Game game = mock(Game.class);
    Level level = mock(Level.class);

    @Test
    @DisplayName("Game Stop")
    @Order(1)
    void testIsInProgress() {
        game.isInProgress();
        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("Player存活与豆子数量test")
    @Order(2)
    @ParameterizedTest
    @CsvSource({
        "true, 1, false",
        "true, 0, false",
        "fasle, 1, fasle",
        "fasle, 0, fasle"
    })
    void testGameStart(boolean x, int y, boolean result) {
        boolean flag;
        x = level.isAnyPlayerAlive();
        y = level.remainingPellets();
        if (!x && (y > 0)) {
            flag = true;
        } else {
            flag = false;
        }
        assertThat(flag).isEqualTo(result);
    }
*/

/*
    PointCalculator pointCalculator = mock(PointCalculator.class);
    Level level = mock(Level.class);

    private final Game game = new Game(pointCalculator) {
        @Override
        public List<Player> getPlayers() {
            return null;
        }

        @Override
        public Level getLevel() {
            return null;
        }
    };

    @Test
    void testIsInProgess() {
        assertThat(game.isInProgress()).isEqualTo(false);
    }

    @Test
    void testIsAnyPlayerAlive() {
        assertThat(level.isAnyPlayerAlive()).isEqualTo(true);
    }

    @Test
    void testRemainingPellets() {
        assertThat(level.remainingPellets()).isGreaterThan(0);
    }
    @Test
    @DisplayName("Game.start方法测试")
    @CsvSource({
        "0, 0, 0, false",
        "0, 0, 1, false",
        "0, 1, 0, false",
        "0, 1, 1, true",
        "1, 0, 0, false",
        "1, 0, 1, false",
        "1, 1, 1, false",
    })
    void testGameStart(boolean x, boolean y, int z, boolean result) {
        assertThat(game.isInProgress()).isEqualTo(true);
    }
*/

}
