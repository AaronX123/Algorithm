package 剑指Offer;

import java.util.Stack;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-06
 */
public class $45 {
    public static String ReverseSentence(String str) {
        char[] chars = reverse(str.toCharArray(),0,str.length() -1);
        int start = 0;
        int end;
        for (int i = 0; i < chars.length; i++) {
            end = i;
            if (chars[i] == ' ' || chars[i] == '.'){
                if (chars[start] == '.'){
                    chars = reverse(chars,start,end - 1);
                    start = end;
                }else {
                    chars = reverse(chars,start + 1,end -1);
                    start = end;
                }
            }
            if (i == chars.length -1){
                if (chars[start] == '.'){
                    chars = reverse(chars,start,end);
                }else {
                    chars = reverse(chars,start + 1,end);
                }
            }

        }
        return new String(chars);
    }


    private static char[] reverse(char[] chars, int start, int end){
        int low = start, high = end;
        while (low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("Wonderful"));
    }

    public String ReverseSentence2(String str) {
        if (str.trim().equals("") && str.length() > 0) {
            return str;
        }
        Stack<String> reverse = new Stack();
        String string = str.trim();
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            reverse.push(strings[i]);
        }
        string = reverse.pop();
        while (!reverse.isEmpty()) {
            string = string + " " + reverse.pop();
        }
        return string;
    }
}
