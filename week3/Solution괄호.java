package week3;

import java.util.*;

class Solution괄호 {
    public int solution(String s) {
        String sb = s + s;
        int answer = 0;
        //✅ 문자열의 길이만큼 반복
        for (int i = 0; i < s.length(); i++) {
            //✅ 문자열을 회전시킨다.
            //✅ 문자열이 유효한지 확인
            //✅ 유효하다면 answer를 1 증가시킨다.
            if (isValid(sb.substring(i, s.length() + i))) answer++;
        }
        return answer;
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char current : s.toCharArray()) {
            if (current == '(' ||  current == '{' ||  current == '[') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) return false;

                char target = stack.pop();
                if ((target == '(' && current != ')') ||
                        (target == '{' && current != '}') ||
                        (target == '[' && current != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}