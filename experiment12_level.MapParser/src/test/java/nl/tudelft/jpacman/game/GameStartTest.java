package nl.tudelft.jpacman.game;


import nl.tudelft.jpacman.level.Level;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class GameStartTest {

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
