public class Board {
    private final String[][] positions = new String[3][3];
    private boolean player = true;

    public boolean placeMove(Position position) {
        boolean playerWins = false;
        final String marker = positions[position.getX()][position.getY()];

        if (marker == null) {
            positions[position.getX()][position.getY()] = getPlayersMarker();
            playerWins = playerWins();
            togglePlayer();
        }

        return playerWins;
    }

    public String getPlayersMarker() {
        return player ? "X" : "O";
    }

    private void togglePlayer() {
        player = !player;
    }

    public String positionToString(Position position) {
        final String marker = positions[position.getX()][position.getY()];

        return marker == null ? "" : marker;
    }

    private boolean playerWins() {
        boolean checkRow = false;
        boolean checkColumn = false;

        for(int i = 0; i < 3; i++) {
            checkRow |= checkRow(i);
        }

        for(int i = 0; i < 3; i++) {
            checkColumn |= checkColumn(i);
        }

        return checkRow|| checkColumn || checkDiagonals();
    }

    private boolean checkRow(int row) {
        final String playersMarker = getPlayersMarker();
        final boolean pos00 = playersMarker.equals(positions[0][row]);
        final boolean pos10 = playersMarker.equals(positions[1][row]);
        final boolean pos20 = playersMarker.equals(positions[2][row]);

        return (pos00 && pos10 && pos20);
    }

    private boolean checkColumn(int column) {
        final String playersMarker = getPlayersMarker();
        final boolean pos00 = playersMarker.equals(positions[column][0]);
        final boolean pos10 = playersMarker.equals(positions[column][1]);
        final boolean pos20 = playersMarker.equals(positions[column][2]);

        return (pos00 && pos10 && pos20);
    }

    private boolean checkDiagonals() {
        final String playersMarker = getPlayersMarker();
        final boolean pos00 = playersMarker.equals(positions[0][0]);
        final boolean pos11 = playersMarker.equals(positions[1][1]);
        final boolean pos22 = playersMarker.equals(positions[2][2]);
        final boolean pos02 = playersMarker.equals(positions[0][2]);
        final boolean pos20 = playersMarker.equals(positions[2][0]);

        return (pos00 && pos11 && pos22) ||
                (pos02 && pos11 && pos20);
    }
}
