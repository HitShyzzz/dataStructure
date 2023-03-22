package leecode.字符串模拟;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/08/30/10:35
 * @Description:
 */
public class 验证IP地址 {
    public static void main(String[] args) {
        String IP="2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(solve(IP));

    }
    public static String solve (String IP) {
        // write code here
        if(IP.length()<7||IP.length()>39){
            return "Neither";
        }
        // IPV4
        if(IP.contains(".")){
            if(IP.charAt(0)=='.'||IP.charAt(IP.length()-1)=='.'){
                return "Neither";
            }
            String[]str=IP.split("\\.");
            if(str.length!=4){
                return "Neither";
            }
            for(String s:str){
                // "1a1.4.5.6"
                // 判断1a1这种情况
                char[]c=s.toCharArray();
                for(int i=0;i<c.length;i++){
                    if(Character.isLetter(c[i])){
                        return "Neither";
                    }
                }
                if(Integer.parseInt(s)<0||Integer.parseInt(s)>255){
                    return "Neither";
                }else if(s.charAt(0) == '0'){
                    return "Neither";
                }
            }
            return "IPv4";
        }else if(IP.contains(":")){// IPV6
            if(IP.charAt(0)==':'||IP.charAt(IP.length()-1)==':'){
                return "Neither";
            }
            String[]str=IP.split(":");
            if(str.length!=8){
                return "Neither";
            }
            for(String s:str){
                // ::或者多余0的情况
                if(s.equals("")||s.equals("00")||s.equals("000")||s.equals("0000")){
                    return "Neither";
                }
                // 16进制
                String s1=s.toLowerCase();
                char[]c=s1.toCharArray();
                for(int i=0;i<c.length;i++){
                    if(Character.isLetter(c[i])){
                        // 保证16进制
                        if(c[i]>'f'||c[i]<'a'){
                            return "Neither";
                        }
                    }
                }
            }
            return "IPv6";
        }else{
            return "Neither";
        }
    }
}
