/**
 * n 皇后问题
 * char 类型需要初始化, 不能设置为null,只能设置为字符, '\0'
 */
public class NQueen {

    public static void main(String[] args) {
        int n = 4;
        char[][] chess = new char[n][n];
        queen(chess, 0);
    }

    public static void queen(char[][] chess, int r) {
        for (int i = 0; i < chess.length; i++) {
            if (i > 0) {
                chess[r][i - 1] = '\0';
            }
            chess[r][i] = 'x';
            if (check(chess, r, i)) {
                if (r == chess.length - 1) {
                    print(chess);
                } else {
                    queen(chess, r + 1);
                }
            }

        }
        chess[r][chess.length - 1] = '\0';
    }

    public static boolean check(char[][] chess, int r, int c) {

        if (r == c) {
            for (int i = 0; i < chess.length; i++) {
                if (i != r) {
                    if ('x' == chess[i][i]) {
                        return false;
                    }
                }
            }
        }

        if (r + c == chess.length - 1) {
            for (int i = 0; i < chess.length; i++) {
                if (i != r) {
                    if ('x' == chess[i][chess.length - 1 - i]) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < chess.length; i++) {
            if (i != r) {
                if ('x' == chess[i][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void print(char[][] chess) {
        for (char[] row : chess) {
            for (char c : row) {
                System.out.print((c == '\0') ? " |" : "x|");
            }
            System.out.println();
        }
        System.out.println("--------");
    }

}