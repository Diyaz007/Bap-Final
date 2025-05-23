public class Warehouse {
    private final int SIZE = 10;
    private Cell[][][] grid = new Cell[SIZE][SIZE][SIZE];
    private Position exitPosition = new Position(0, 0, 0); // выход в (0,0,0)

    public Warehouse() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                for (int z = 0; z < SIZE; z++) {
                    grid[x][y][z] = new Cell(x, y, z);
                }
            }
        }
    }

    public Cell getCell(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= SIZE || y >= SIZE || z >= SIZE) return null;
        return grid[x][y][z];
    }

    public Position getExitPosition() {
        return exitPosition;
    }

    public double distanceFromExit(Cell cell) {
        Position pos = new Position(cell.getX(), cell.getY(), cell.getZ());
        return pos.distanceTo(exitPosition);
    }

    public int getSize() {
        return SIZE;
    }
}
