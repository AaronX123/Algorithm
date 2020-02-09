package bilibili;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-06
 */
public class QueueStack {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> helpQueue = new LinkedList<>();

    public int pop(){
        int k = queue.size();
        for (int i = 0; i < k - 1; i++) {
            helpQueue.add(queue.poll());
        }
        int result = queue.poll();
        k = helpQueue.size();
        for (int i = 0; i < k; i++) {
            queue.add(helpQueue.poll());
        }
        return result;
    }

    public void push(int val){
        queue.add(val);
    }

    public int peek(){
        int result = pop();
        queue.add(result);
        return result;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(1000,9999));
        }

    }
}
