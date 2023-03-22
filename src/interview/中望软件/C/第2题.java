package interview.中望软件.C;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/28/16:43
 * @Description:
 */
public class 第2题 {
    public static void main(String[] args) {
        int m=3;
        int n=6;
        double tol=0.000001;
        double solve = solve(m, n, tol);
        System.out.println(solve);

    }

    /**
     * 输出x,使得|e^x+x^m-n|<tol成立！
     * 二分查找吧
     * @param m
     * @param n
     * @param tol
     * @return
     */
    public static double solve(int m,int n,double tol){
        double l=0.0;
        double r=Math.log(10000000);
        double ans=0.0;

        while (l<r){
            double mid=(l+r)/2;
            if(Math.exp(mid)+Math.pow(mid,m)>tol+n){
                r=mid;
            } else if (Math.exp(mid)+Math.pow(mid,m)<n-tol) {
                l=mid;
            }else {
                ans=(double) (Math.round(mid*100000)/100000);
            }
        }
        return ans;
    }
}
