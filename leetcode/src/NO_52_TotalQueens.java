import java.util.HashSet;
import java.util.Set;

public class NO_52_TotalQueens {


    int[][] result = new int[5][5];

    public int totalNQueens(int n) {

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        return  backtrack( n, 0, columns, diagonals1, diagonals2);
    }


    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {

        int count = 0;

        if (row == n) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (result[i][j] == 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.print("\n");
            }

            System.out.print("\n");
            return 1;
        } else {
            for (int i = 0; i < n; i ++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }

                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                result[row][i] = 1;

                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                result[row][i] = 0;
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        NO_52_TotalQueens queens = new NO_52_TotalQueens();

        queens.totalNQueens(5);

    }
}


