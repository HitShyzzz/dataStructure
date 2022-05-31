package solution;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/05/23/17:58
 * @Description:
 */
public class Gale_Shapley {
    public static void getResult(int[][] boys, int[][] girls) {
        int[] result = new int[boys.length];
        int[] used = new int[girls.length];   //最终女士配对的男士
        for(int i = 0;i < girls.length;i++) {
            used[i] = -1;
            result[i] = -1;
        }
        int count = 0;   //统计已完成配对个数
        while(count < boys.length) {
            for(int i = 0;i < boys.length;i++) {
                if(result[i] != -1)   //当男士i已完成配对时，进行下一个男士配对
                    continue;
                for(int j = 0;j < boys[0].length;j++) {
                    if(used[boys[i][j]] == -1) {
                        used[boys[i][j]] = i;       //女士boys[i][j]与男士i配对
                        result[i] = boys[i][j];    //男士i和女士boys[i][j]配对
                        break;  //男士i完成配对，退出循环
                    } else {
                        int temp = 0, temp1 = 0;
                        for(;temp < girls[0].length;temp++) {  //求出男士i在女士boys[i][j]心中的优先级
                            if(girls[boys[i][j]][temp] == i)
                                break;
                        }
                        for(;temp1 < girls[0].length;temp1++) { //求出当前女士已配对男士在其心中的优先级
                            if(girls[boys[i][j]][temp1] == used[boys[i][j]])
                                break;
                        }
                        if(temp < temp1) {  //当男士i比目前已与女士配对的男士优先级要高时
                            result[used[boys[i][j]]] = -1;   //已配对男士被踢
                            used[boys[i][j]] = i;    //当前女士的配偶换成男士i
                            result[i] = boys[i][j];
                            break;       //男士i完成配对，退出循环
                        }
                    }
                }
            }
            count = 0;
            for(int i = 0;i < used.length;i++) {
                if(used[i] != -1)
                    count++;
            }
        }
        System.out.println("稳定婚姻匹配结果是：");
        //打印出结果
        for(int i = 0;i < result.length;i++)
            System.out.println("男士"+i+"和女士"+result[i]+"配对");
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入男生和女生的人数：");
        int n = in.nextInt();
        int[][] boys = new int[n][n];         //男士的心中对象优先级
        int[][] girls = new int[n][n];        //女士的心中对象优先级
        System.out.println("请输入男生心仪女生矩阵：");
        // 0 1 2 0 2 1 2 0 1
        for(int i = 0;i < n;i++) {
            int one = in.nextInt();   //优先级为1
            int two = in.nextInt();   //优先级为2
            int three = in.nextInt();  //优先级为3
            boys[i][0] = one;
            boys[i][1] = two;
            boys[i][2] = three;
        }
        System.out.println("请输入女生心仪男生矩阵：");
        // 2 0 1 1 2 0 1 2 0
        for(int i = 0;i < n;i++) {
            int one = in.nextInt();   //优先级为1
            int two = in.nextInt();   //优先级为2
            int three = in.nextInt();  //优先级为3
            girls[i][0] = one;
            girls[i][1] = two;
            girls[i][2] = three;
        }
        getResult(boys, girls);
    }

}
