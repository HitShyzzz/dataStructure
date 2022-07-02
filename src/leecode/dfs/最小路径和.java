package leecode.dfs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/02/15:58
 * @Description:
 */
public class 最小路径和 {
    public static void main(String[] args) {
        //int[][]grid={{1,3,1},{1,5,1},{4,2,1} };
        int[][]grid={{1,2,3},{4,5,6}};
        int pathSum = minPathSum(grid);
        System.out.println(pathSum);
    }

    private static int minPath=Integer.MAX_VALUE;
    /**
     * 跟前面的不同路径题目做法是一样的，暴力搜索就完事了！
     * 暴力搜索虽然写起来很爽，但跟前面一样依然会超时！
     * 就算做一些剪枝优化，时间复杂度肯定还是很高的；
     * 不如用动态规划来减少时间复杂度！
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][]visited=new boolean[m][n];
        dfs(grid,0,0,visited,grid[0][0]);
        return minPath;
    }

    public static void dfs(int[][]grid,int i,int j,boolean[][]visited,int sum){
        if(i== grid.length||j==grid[0].length){

            return;
        }
        if(i== grid.length-1&&j==grid[0].length-1){
                minPath=Math.min(minPath,sum);
                return;
        }
        // 向下走
        if(i+1<grid.length&&!visited[i+1][j]){
            visited[i+1][j]=true;
            dfs(grid,i+1,j,visited,sum+grid[i+1][j]);
            visited[i+1][j]=false;
        }
        // 向右走
        if(j+1<grid[0].length&&!visited[i][j+1]){
            visited[i][j+1]=true;
            dfs(grid,i,j+1, visited,sum+grid[i][j+1]);
            visited[i][j+1]=false;
        }
    }
}
