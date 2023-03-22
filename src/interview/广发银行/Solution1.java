package interview.广发银行;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/07/13/16:35
 * @Description:
 */
public class Solution1 {
    public String printIDCard (String str) {
        // write code here
        String area[]={"11","12","13","14","15","21","22","23","31","32","33","34","35","36","37",
        "41","42","43","44","45","46","50","51","52","53","54","61","62","63","64","65","71","81","82","91"
        };
        for(int i=0;i<area.length;i++){
            if(!str.contains(area[i])){
                return "false";
            }
        }
        String IDCard="";
        return "false"+" "+IDCard;
    }
}
