package week1;

import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스를 저장

        for (int i = 0; i < n; i++) {
            // 새로 들어온 i번째 날의 온도 T[i]가
            // 스택에 저장된 인덱스들의 온도보다 높으면,
            // 그 인덱스의 정답을 (i - 그 인덱스)로 확정 짓는다
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            // 아직 올라갈 날을 기다려야 할 인덱스 i를 스택에 저장
            stack.push(i);
        }
        return answer;
    }
}
