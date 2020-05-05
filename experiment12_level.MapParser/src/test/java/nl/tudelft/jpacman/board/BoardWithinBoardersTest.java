package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BoardWithinBoardersTest {
    private static final int MAX_WIDTH = 3;
    private static final int MAX_HEIGHT = 4;

    private static  Square[][] grid = {
        {mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class)},
        {mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class)},
        {mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class)}
    };

    private final Board board = new Board(grid);

    @Test
    void verifyWidth() {
        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHT);
    }

    @Test
    void verifyHeight() {
        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
    }

    @DisplayName("边界值方法测试游戏棋盘边界")
    @ParameterizedTest
    @CsvSource({
        "0, 2, true",
        "1, 2, true",
        "1, 0, true",
        "1, 1, true",
        "1, 4, false",
        "3, 2, false",
        "1, 3, true",
    })
    void testWithinBoarder(int x, int y, boolean result) {
        assertThat(board.withinBorders(x, y)).isEqualTo(result);
    }
}
