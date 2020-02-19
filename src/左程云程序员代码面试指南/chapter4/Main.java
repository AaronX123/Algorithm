package 左程云程序员代码面试指南.chapter4;

import java.util.*;

public class Main {
    private static int index = 0;

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
        if (prices.length<=0||budget<=0){
            throw new IllegalArgumentException("不能为空");
        }
        Arrays.sort(prices);
        if (budget<prices[0]){
            return -1;
        }
        //比最大的数都大
        if (budget>prices[prices.length-1]){
            index = budget/prices[prices.length-1];
            budget = budget%prices[prices.length-1];
        }
        try {
            count(prices,budget);
        }catch (IllegalArgumentException e){
            return -1;
        }

        return index;
    }

    private static void count(int[] prices,int currentMoney){
        if (currentMoney<=0){
            return;
        }
        if (prices.length==1){
            if (currentMoney%prices[0]==0){
                index = currentMoney/prices[0];
            }else {
                throw new IllegalArgumentException("无解");
            }
        }
        while (currentMoney>0){
            for (int i = 1; i < prices.length; i++) {
                if (currentMoney<=prices[0]){
                    if (currentMoney%prices[0]==0){
                        index = currentMoney/prices[0];
                    }else {
                        throw new IllegalArgumentException("无解");
                    }
                }
                if (currentMoney<=prices[i]){
                    index+=currentMoney/prices[i-1];
                    currentMoney = currentMoney%prices[i-1];
                    count(prices,currentMoney);
                    return;
                }
            }
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}