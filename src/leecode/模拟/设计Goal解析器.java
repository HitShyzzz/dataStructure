package leecode.模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/11/06/11:58
 * @Description:
 */
public class 设计Goal解析器 {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";// alGalooG
        String interpret = interpret(command);
        System.out.println(interpret);
    }

    // G()()()()(al)----》Gooooal
    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'G') {
                sb.append(c);
            } else if (c == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++;
                } else {
                    sb.append("al");
                    i = i + 3;
                }
            }
        }
        return sb.toString();
    }
}
