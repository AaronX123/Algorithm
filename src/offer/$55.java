package offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-12
 */
public class $55 {
    Map<Character,Integer> map = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!map.containsKey(ch)){
            map.put(ch,1);
        }else {
            map.put(ch,2);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '#';
    }
}
