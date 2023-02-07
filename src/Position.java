public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y)
    {
        assert x >= 0 && x <= 2;
        assert y >= 0 && y <= 2;

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
