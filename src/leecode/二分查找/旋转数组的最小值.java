package leecode.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/05/10:19
 * @Description:
 */
public class 旋转数组的最小值 {
    /**
     * 二分查找，我们还是让l=0,r=n-1,mid=(l+r)/2;细节代码里都有注释
     * O(T)=O(logn);
     * O(S)=O(1);
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // array[mid]<array[r],那么旋转的起始点一定在左半段，
            if (array[mid] < array[r]) {
                r = mid;
                // array[mid]>array[r],那么旋转的起始点一定在右半段
            } else if (array[mid] > array[r]) {
                l = mid + 1;
            } else {// arr[mid]==arr[r],此时无法判断旋转起始点到底在哪一段，只好j--继续判断，
                r--;
            }
        }
        return array[l];
    }
}
