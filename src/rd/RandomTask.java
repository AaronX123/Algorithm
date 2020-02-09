package rd;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-06
 */
public class RandomTask {
    private int[] data;
    private int n;
    private int sum;
    private int[] book;
    private int[] result;
    private Random random=new Random();
    public RandomTask(int n, int sum){
        this.n=n;
        this.sum=sum;
        book = new int[sum];
        data = new int[sum];
        for (int i=0;i<sum;i++){
            data[i]=i;
        }
        result = new int[n];
    }

    public void gen(){
        for (int i=0;i<n;i++){
            int index=random.nextInt(sum);
            //如果已取出，则需要再生成一个不重复的
            while (book[index]==1){
                    index=random.nextInt(sum);
            }
            //将其标记为取出状态
            book[index]=1;
            result[i]=data[index];
        }
    }

    public int[] getResult(){
        return this.result;
    }

    public static void main(String[] args) {
        RandomTask randomTask=new RandomTask(10,50);
        randomTask.gen();
        System.out.println(Arrays.toString(randomTask.getResult()));
    }
}
