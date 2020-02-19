package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-10
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
