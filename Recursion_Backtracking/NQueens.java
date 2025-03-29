import java.util.*;

class NQueens {
    private static List<List<String>> solutions = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0);
        return solutions;
    }

    private static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            solutions.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) 
            if (board[i][col] == 'Q') return false;
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) 
            if (board[i][j] == 'Q') return false;
        
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) result.add(new String(row));
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size (N): ");
        int n = sc.nextInt();
        List<List<String>> results = solveNQueens(n);
        
        System.out.println("Solutions: ");
        for (List<String> sol : results) {
            for (String row : sol) System.out.println(row);
            System.out.println();
        }
        sc.close();
    }
}
