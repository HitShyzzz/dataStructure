package leecode.二分查找;

import leecode.每日温度;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/14/19:27
 * @Description:
 */
public class 搜索二维矩阵II {

    /**
     * 直接查找的话时间复杂度是O(mn)，虽然能通过，但时间复杂度是比较高的；
     * 这里利用每行每列都有序的特点，对矩阵的每一行进行二分查找，来优化时间复杂度；
     * O(T)=O(mlogn),每行进行二叉查找的时间复杂度是O(logn),总共有m行，因此时间复杂度是O(mlogn);
     * O(S)=O(1);
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
           if(binarySearch(matrix,i,target)){
               return true;
            }
        }
        return false;
    }

    /**
     * 在矩阵的第i行进行二分查找
     * @param matrix
     * @param i
     * @param target
     * @return
     */
    public boolean binarySearch(int[][]matrix,int i,int target){
        int n=matrix[i].length;
        int l=0;
        int r=n-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(matrix[i][mid]==target){
                return true;
            }else if(matrix[i][mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}
