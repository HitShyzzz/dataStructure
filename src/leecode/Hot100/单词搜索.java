package leecode.Hot100;

/**
 * @version: java version 18
 * @Author: Shy
 * @description:
 * @date: 2024-07-02 20:18
 */
public class 单词搜索 {
    static boolean flag = false;

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    // 输出：true
    public static boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 以每个位置[i,j]为起点开始一一遍历
                boolean ans = dfs(board, word, sb, i, j, visited);
                if (ans) return true;
            }
        }
        return false;
    }

    // 一一添加每个字符去和word比较，做了许多无用计算，超时！
    public static boolean dfs(char[][] board, String word, StringBuilder sb, int i, int j, boolean[][] visited) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) return false;
        sb.append(board[i][j]);
        if (word.equals(sb.toString())) return true;
        visited[i][j] = true;
        // 向上
        if (i > 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            flag = dfs(board, word, sb, i - 1, j, visited);
            if (flag) return true;
            visited[i - 1][j] = false;
        }
        // 向下
        if (i < board.length - 1 && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            flag = dfs(board, word, sb, i + 1, j, visited);
            if (flag) return true;
            visited[i + 1][j] = false;
        }
        // 向左
        if (j > 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            flag = dfs(board, word, sb, i, j - 1, visited);
            if (flag) return true;
            visited[i][j - 1] = false;
        }
        // 向右
        if (j < board[0].length - 1 && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            flag = dfs(board, word, sb, i, j + 1, visited);
            if (flag) return true;
            visited[i][j + 1] = false;
        }

        // 回溯
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
        return flag;
    }
}
