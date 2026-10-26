package recursions;

public class sudoku_solver {
    public static boolean[][] rows = new boolean[9][10];
    public static boolean[][] cols = new boolean[9][10];
    public static boolean[][] box = new boolean[9][10];

    static void main() {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    rows[i][num] = true;
                    cols[j][num] = true;
                    box[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        if (helper(board, 0, 0, n)) {
            for (int[] r : board) {
                for (int x : r) System.out.print(x + " ");
                System.out.println();
            }
        } else {
            System.out.println("No solution");
        }

    }

    public static boolean helper(int[][] board, int row, int col, int n) {
        if (row == n) {
            return true;
        }

        if (col == n) {
            return helper(board, row + 1, 0, n);
        }

        for (int i = 1; i <= 9; i++) {
            if (board[row][col] != 0) {
                return helper(board, row, col + 1, n);
            }

            if (rows[row][i] || cols[col][i] || box[(row / 3) * 3 + (col / 3)][i]) continue;

            board[row][col] = i;
            rows[row][i] = true;
            cols[col][i] = true;
            box[(row / 3) * 3 + (col / 3)][i] = true;

            if (helper(board, row, col + 1, n)) {
                return true;
            }

            board[row][col] = 0;
            rows[row][i] = false;
            cols[col][i] = false;
            box[(row / 3) * 3 + (col / 3)][i] = false;
        }
        return false;
    }
}
