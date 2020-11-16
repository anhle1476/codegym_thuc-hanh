public class Main {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."},
                {".", ".", ".", "*", "."},
                {".", "*", ".", ".", "."},
                {".", "*", ".", ".", "."},
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];
        for (int dY = 0; dY < MAP_HEIGHT; dY++) {
            for (int dX = 0; dX < map[0].length; dX++) {
                String currentCell = map[dY][dX];
                if (currentCell.equals("*")) {
                    mapReport[dY][dX] = "*";
                    continue;
                }
                final int[][] NEIGHBOURS_ORDINATE = {
                        {dY - 1, dX - 1},
                        {dY - 1, dX},
                        {dY - 1, dX + 1},
                        {dY, dX - 1},
                        {dY, dX + 1},
                        {dY + 1, dX - 1},
                        {dY + 1, dX},
                        {dY + 1, dX + 1},
                };

                int minesAround = 0;
                for (int[] neighbourOrdinate : NEIGHBOURS_ORDINATE) {
                    int neighbourX = neighbourOrdinate[1];
                    int neighbourY = neighbourOrdinate[0];

                    boolean isOutOfMapNeighbour = neighbourX < 0
                            || neighbourX == MAP_WIDTH
                            || neighbourY < 0
                            || neighbourY == MAP_HEIGHT;
                    if (isOutOfMapNeighbour) continue;

                    boolean isMineOwnerNeighbour = map[neighbourY][neighbourX].equals("*");
                    if (isMineOwnerNeighbour) minesAround++;
                }

                mapReport[dY][dX] = String.valueOf(minesAround);
            }
        }

        for (String[] row : mapReport) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
