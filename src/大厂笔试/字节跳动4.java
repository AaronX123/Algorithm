package 大厂笔试;

import java.util.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-15
 */
public class 字节跳动4 {
    static class User{
        String user;
        String model;

        public User(String user, String model) {
            this.user = user;
            this.model = model;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            users[i] = get(scanner.nextLine());
        }
        Map<String, List<String>> map = new HashMap<>();
        List<String> models = new ArrayList<>();
        for (User user : users) {
            if (!models.contains(user.model)){
                models.add(user.model);
            }
        }
        for (String s : models) {
            List<String> s2 = new ArrayList<>();
            for (User user : users) {
                if (user.model.equals(s)){
                    s2.add(user.user);
                }
            }
            s2.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            map.put(s,s2);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+merge(entry.getValue()));
        }
    }

    private static String merge(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }

    private static User get(String line){
        String[] strings = line.split(" ");
        return new User(strings[0],strings[1]);
    }
}
