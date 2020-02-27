package acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入一组数字（可能包含重复数字），输出其所有的排列方式。
 *
 * 样例
 * 输入：[1,2,3]
 *
 * 输出：
 *       [
 *         [1,2,3],
 *         [1,3,2],
 *         [2,1,3],
 *         [2,3,1],
 *         [3,1,2],
 *         [3,2,1]
 *       ]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-20
 */
public class 数字排列 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permutation(int[] nums) {
        if (nums == null || nums.length <=0){
            return new ArrayList<>();
        }
        dfs(new ArrayList<>(),nums,0,new int[nums.length]);
        res = res.stream().distinct().collect(Collectors.toList());
        return res;
    }

    /**
     *
     * @param list
     * @param nums
     * @param depth
     * @param book 已经取用的nums下标
     */
    public void dfs(List<Integer> list, int[] nums, int depth, int[] book){
        if (depth == nums.length - 1){
            for (int i = 0; i < book.length; i++) {
                if (book[i] == 0){
                    list.add(nums[i]);
                    List<Integer> t = new ArrayList<Integer>(list.size());
                    for (Integer integer : list) {
                        t.add(integer);
                    }
                    res.add(t);
                    list.remove(list.size() - 1);
                    return;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (book[i] == 0){
                list.add(nums[i]);
                book[i] = 1;
                dfs(list,nums,++depth,book);
                depth--;
                book[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new 数字排列().permutation(new int[]{1,2});
    }
}
