package week1;

import java.util.*;
import java.io.*;
public class StockPrice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> q = new ArrayDeque<>();

        for(int value : prices) {
            q.add(value);
        }

        int index = 0;
        while(!q.isEmpty()) {
            int currentPrice = q.poll();
            for (int i = prices.length - q.size(); i < prices.length; i++) {
                if (currentPrice > prices[i]) {
                    answer[index]++;
                    break;
                }
                if (currentPrice <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }

        return answer;
    }
}
