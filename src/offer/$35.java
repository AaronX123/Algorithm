package offer;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-04
 */
public class $35 {
    public int FirstNotRepeatingChar(String str) {
        // 58为a-Z的ascii码数目
        int[] words = new int[58];
        // 将字母装进桶里
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        // 统计出现次数为1的位置
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }
}
