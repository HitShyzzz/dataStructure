package leecode.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/07/9:23
 * @Description:
 */
public class 重新排列单词间的空格 {
    public static void main(String[] args) {
        String  text = "  this   is  a sentence ";
        String s = reorderSpaces(text);
        System.out.println(s);
    }
    // text = "  this   is  a sentence "--->"this   is   a   sentence"
    // 9个空格，4个单词，每个单词平均分9/(4-1)=3个空格，余数个空格放末尾
    public static String reorderSpaces(String text) {
        int n = text.length();
        String[] words = text.trim().split("\\s+", -1);
        int cntSpace = n;// 空格的个数
        int cntWord= words.length;// 单词的个数
        for(String word:words){
            cntSpace-=word.length();
        }
        // 只有1个单词
        StringBuilder sb=new StringBuilder();
        if (words.length==1){
            sb.append(words[0]);
            for(int i=0;i<cntSpace;i++){
                sb.append(' ');
            }
            return sb.toString();
        }
        int midSpace=cntSpace/(cntWord-1);
        int restSpace=cntSpace%(cntWord-1);
        for (int i=0;i<words.length;i++){
            if (i>0){
                for(int j=0;j<midSpace;j++){
                    sb.append(' ');
                }
            }
            sb.append(words[i]);
        }
        for(int i=0;i<restSpace;i++){
            sb.append(' ');
        }
        return sb.toString();
    }
}
