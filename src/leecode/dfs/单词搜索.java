package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/04/18:04
 * @Description:
 */
public class 单词搜索 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    private static boolean flag = false;

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean f = dfs(board, word, visited, i, j, 0);
                if (f) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对于每一个位置，我们都可以上下左右四个方向进行遍历
     * 对于word的每一个位置字符我们都需要一一判断，只有当前字符和word[k]相等时，才会继续向下走！
     * 如果能走到word的最后一个字符，那说明就找到了，就可以返回true了!
     *
     * @param board 原单词矩阵
     * @param word  要搜索的单词
     * @param i     当前遍历到的横坐标
     * @param j     当前遍历到的纵坐标
     * @return
     */
    public static boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        // 如果当前字符不是word里需要的，就直接false，不用往下走了！
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        // 能走到最后，就说明找到了！
        if (k == word.length() - 1) {
            return true;
        }
        // 访问当前结点
        visited[i][j] = true;
        // 向上遍历
        if (i > 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            flag = dfs(board, word, visited, i - 1, j, k + 1);
            if (flag) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        // 向下遍历
        if (i < board.length - 1 && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            flag = dfs(board, word, visited, i + 1, j, k + 1);
            if (flag) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        // 向左遍历
        if (j > 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            flag = dfs(board, word, visited, i, j - 1, k + 1);
            if (flag) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        // 向右遍历
        if (j < board[0].length - 1 && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            flag = dfs(board, word, visited, i, j + 1, k + 1);
            if (flag) {
                return true;
            }
            visited[i][j + 1] = false;
        }
        // 进行回溯
        visited[i][j] = false;
        return false;
    }
}
