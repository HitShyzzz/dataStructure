package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/09/9:36
 * @Description:
 */
public class 文件夹操作日志搜集器 {
    public static void main(String[] args) {
        String[] logs = {"./", "../", "./"};
        int i = minOperations(logs);
        System.out.println(i);
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            String cur = logs[i];
            if (cur.equals("./")) {
                continue;
            } else if (cur.equals("../")) {
                if (count > 0) {
                    count--;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
