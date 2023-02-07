import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    public void placeMoveOnEmptyBoard()
    {
        final Board board = new Board();

        Position position = new Position(1, 2);
        board.placeMove(position);
        assertEquals("X", board.positionToString(position));
        assertEquals("", board.positionToString(new Position(0,0)));
    }

    @Test
    public void playersAlternatePlacingXandOs()
    {
        final Board board = new Board();

        Position position = new Position(0, 0);
        board.placeMove(position);
        assertEquals("X", board.positionToString(position));

        position = new Position(1, 1);
        board.placeMove(position);
        assertEquals("O", board.positionToString(position));

        position = new Position(0, 1);
        board.placeMove(position);
        assertEquals("X", board.positionToString(position));
    }

    @Test
    public void playersCannotPlayOnAPlayedPosition()
    {
        final Board board = new Board();

        Position position = new Position(1, 2);
        board.placeMove(position);
        assertEquals("X", board.positionToString(position));
        assertEquals("O", board.getPlayersMarker());

        board.placeMove(position);
        assertEquals("X", board.positionToString(position));
        assertEquals("O", board.getPlayersMarker());
    }

    @Test
    public void playerWinsOnRow0()
    {
        final Board board = new Board();

        assertFalse(board.placeMove(new Position(0, 0)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(1, 0)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertTrue(board.placeMove(new Position(2, 0)));
    }

    @Test
    public void playerWinsOnRow1()
    {
        final Board board = new Board();

        assertFalse(board.placeMove(new Position(0, 0)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(1, 0)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertFalse(board.placeMove(new Position(2, 2)));
        assertTrue(board.placeMove(new Position(0, 1)));
    }

    @Test
    public void playerWinsOnRow2()
    {
        final Board board = new Board();

        assertFalse(board.placeMove(new Position(0, 2)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(1, 2)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertTrue(board.placeMove(new Position(2, 2)));
    }

    @Test
    public void playerWinsOnColumn0()
    {
        final Board board = new Board();

        assertFalse(board.placeMove(new Position(0, 0)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(0, 1)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertTrue(board.placeMove(new Position(0, 2)));
    }

    @Test
    public void playerWinsOnColumn1()
    {
        final Board board = new Board();

        assertFalse(board.placeMove(new Position(1, 0)));
        assertFalse(board.placeMove(new Position(0, 0)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertTrue(board.placeMove(new Position(1, 2)));
    }

    @Test
    public void playerWinsOnColumn2()
    {
        final Board board = new Board();

        assertFalse(board.placeMove(new Position(0, 0)));
        assertFalse(board.placeMove(new Position(2, 0)));
        assertFalse(board.placeMove(new Position(1, 0)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertTrue(board.placeMove(new Position(2, 2)));
    }

    @Test
    public void playerWinsOnDiagonal()
    {
        Board board = new Board();

        assertFalse(board.placeMove(new Position(0, 0)));
        assertFalse(board.placeMove(new Position(1, 0)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertTrue(board.placeMove(new Position(2, 2)));

        board = new Board();

        assertFalse(board.placeMove(new Position(0, 2)));
        assertFalse(board.placeMove(new Position(1, 0)));
        assertFalse(board.placeMove(new Position(1, 1)));
        assertFalse(board.placeMove(new Position(2, 1)));
        assertTrue(board.placeMove(new Position(2, 0)));
    }
}
