package leecode.有限状态自动机;

import interview.海康卫视.Person;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2022/09/10/9:50
 * @Description:
 */
public class 有效数字 {
    // "53.5e93"√ "99e2.5"×
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        Map<CharType, State> initialMap = new HashMap<>();
        initialMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        initialMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        initialMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<>();
        intSignMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intSignMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> intMap = new HashMap<>();
        intMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        intMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        transfer.put(State.STATE_INTEGER, intMap);
        Map<CharType, State> pointMap = new HashMap<>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<>();
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_INT);
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_INT);
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<>();
        expNumberMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_INT);
        transfer.put(State.STATE_EXP_INT, expNumberMap);
        int len = s.length();
        State state = State.STATE_INITIAL;
        for (int i = 0; i < len; i++) {
            CharType c = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(c)) {
                return false;
            } else {
                state = transfer.get(state).get(c);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_EXP_INT || state == State.STATE_FRACTION || state == State.STATE_EXP_END;
    }

    public CharType toCharType(char c) {
        if (c >= '0' && c <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (c == '.') {
            return CharType.CHAR_POINT;
        } else if (c == 'e' || c == 'E') {
            return CharType.CHAR_EXP;
        } else if (c == '+' || c == '-') {
            return CharType.CHAR_SIGN;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    // 列举所有状态
    enum State {
        STATE_INITIAL, // 初始态
        STATE_INT_SIGN, // 整数符号位
        STATE_INTEGER, // 整数位
        STATE_POINT,// 小数点
        STATE_POINT_WITHOUT_INT, // 小数点前没有整数
        STATE_FRACTION, // 小数位
        STATE_EXP, // 指数位
        STATE_EXP_SIGN, // 指数符号位
        STATE_EXP_INT, // 指数整数位
        STATE_EXP_END // 结束态
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_SIGN,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_ILLEGAL;
    }
}
