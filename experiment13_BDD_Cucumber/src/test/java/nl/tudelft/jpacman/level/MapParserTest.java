package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class MapParserTest {

    private MapParser mapParser;
    private final LevelFactory levelFactory = mock(LevelFactory.class);
    private final BoardFactory boardFactory = mock(BoardFactory.class);

    @BeforeEach
    void setUp() {
        mapParser = new MapParser(levelFactory, boardFactory);
        when(boardFactory.createGround()).thenReturn(mock(Square.class));
        when(boardFactory.createWall()).thenReturn(mock(Square.class));
        when(levelFactory.createGhost()).thenReturn(mock(Ghost.class));
        when(levelFactory.createPellet()).thenReturn(mock(Pellet.class));
    }

    @Test
    @Order(1)
    @DisplayName("文件名为空")
    void testFileNameIsNull() {
        assertThatThrownBy(() -> {
            mapParser.parseMap((String) null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @Order(2)
    @DisplayName("文件不存在")
    void testFileIsNotExist() {
        String file = "/board2.txt";
        assertThatThrownBy(() -> {
            mapParser.parseMap(file);
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Could not get resource for: " + file);
    }

    @Test
    @Order(3)
    @DisplayName("文件包含非法字符")
    void testFileNameHasIllegalCharacter() {
        String file = "/board3.txt";
        assertThatThrownBy(() -> {
            mapParser.parseMap(file);
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Invalid character at 0,0: A");
    }

    @Test
    @Order(4)
    @DisplayName("文件正常存在")
    void testFileExist() throws IOException {
        String file = "/board4.txt";
        mapParser.parseMap(file);

        verify(boardFactory, times(5)).createGround();
        verify(boardFactory, times(3)).createWall();
        verify(levelFactory).createGhost();
    }
}
