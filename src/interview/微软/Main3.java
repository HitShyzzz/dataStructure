package interview.微软;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/26/20:13
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        int[]arr={1,2,3};
        Main3 main3 = new Main3();
        int i = main3.missMinNum(arr, arr.length);
        System.out.println(i);

    }
    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int N=A.length;
        int[]C=new int[N];
        for(int i=0;i<N;i++){
            C[i]=Math.max(A[i],B[i]);
        }
        int num = missMinNum(C, N);
        return num;
    }
    // 缺失的最小正整数
   public int missMinNum(int arr[], int n) {
        int l = 0;
        int r = n;
        int temp;
        while(l < r) {
            if(arr[l] == l + 1){//在理想的位置
                l++;
            }else if(arr[l] > r || arr[l] <= l || arr[arr[l] - 1] == arr[l]){//不合法的数据
                arr[l] = arr[--r];
            }else{//合法但是没有在理想的位置上
                temp=arr[l];
                arr[l]=arr[arr[l]-1];
                arr[temp-1]=temp;
            }
        }
         return  l+ 1;
    }
}
