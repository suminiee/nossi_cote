package week3;

import java.util.*;
class 단어변환 {

    class WordState {
        int count;
        String word;

        WordState(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }

    int getDiffCount(String word, String target) {
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) diffCount++;
        }

        return diffCount;
    }

    public int solution(String begin, String target, String[] words) {
        //BFS
        int answer = 0;

        //배열 큐 선언
        boolean[] visited = new boolean[words.length];
        Queue<WordState> q = new ArrayDeque<>();

        q.add(new WordState(0, begin));

        //BFS
        while(!q.isEmpty()) {
            WordState cur = q.poll();

            //단어가 목표랑 일치하다면 return
            if (cur.word.equals(target)) return cur.count;

            for (int i = 0; i < words.length; i++) {
                //방문하지 않았고, 현재 단어랑 배열속 단어가 다른게 알파벳 한글자라면
                if (!visited[i] && getDiffCount(cur.word, words[i]) == 1) {
                    visited[i] = true;
                    q.add(new WordState(cur.count+1, words[i]));
                }
            }
        }
        return 0;
    }
}