package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-02
 */

import java.util.*;
public class Main{
    public static String format( String template, Map<String,Object> param){
        int index1 = template.indexOf("{");
        int endIndex1 = template.indexOf("}",index1);
        int index2 = template.indexOf("{",endIndex1);
        int endIndex2 = template.indexOf("}",index2);

        char[] s = template.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        entrySet.forEach(stringObjectEntry -> {
            for (int i=0;i<index1;i++){
                stringBuilder.append(s[i]);
            }
            stringBuilder.append(stringObjectEntry.getKey().toString());
            for (int j = endIndex1;j<index2;j++){
                stringBuilder.append(s[j]);
            }
            stringBuilder.append(stringObjectEntry.getValue().toString());
            for(int k = endIndex2+5;k<s.length;k++){
                stringBuilder.append(s[k]);
            }
        });
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            String s_nextLine = scan.nextLine();
            String[] line = s_nextLine.split("\\s+");
            String template = line[0];
            Map<String, Object> param = new HashMap<>();
            for (int i = 1; i < line.length; i += 2) {
                param.put(line[i], line[i + 1]);
            }
            System.out.println(format(template, param));
        } finally {
            scan.close();
        }
    }
}