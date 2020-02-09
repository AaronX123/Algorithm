package offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 1,1,3,3,5,6,6,7,8,8,9,9,10,10,300,300
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-05
 */
public class $41 {
    /**
     * hashmap法
     * @param array
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce(int [] array,int[] num1 , int[] num2) {
        Map<Integer,Integer> map = new HashMap<>(array.length / 2 + 2);
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.remove(array[i]);
            }else {
                map.put(array[i],0);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        if (iterator.hasNext()){
            num1[0] = iterator.next();
            num2[0] = iterator.next();
        }
    }

    /**
     * 异或法，两个相同的数字异或为0，任何数与0异或得到的是本身，将数组中所有数字异或的结果就是2个出现一次
     * 的数字的异或结果，然后从低位开始找到第一个为1的位，并记录下是第几位，然后将数组中这个位为1的分成
     * 2组，然后继续异或，最后得到
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int num=0;
        for(int i=0;i<array.length;i++){
            num^=array[i];//所有数异或，结果为不同的两个数字的异或
        }
        int count=0;//标志位，记录num中的第一个1出现的位置
        for(;count<array.length;count++){
            if((num&(1<<count))!=0){
                break;
            }
        }
        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if((array[i]&(1<<count))==0){//标志位为0的为一组，异或后必得到一个数字（这里注意==的优先级高于&，需在前面加（））
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];//标志位为1的为一组
            }
        }
    }
}
