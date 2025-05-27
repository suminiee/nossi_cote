package week3;

import java.util.*;
public class Solution1844 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        int answer = 0;
        //r, c
        int r = maps.length;
        int c = maps[0].length;
        //배열, 큐 선언
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new ArrayDeque<>();
        //시작 점 큐에 삽입
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            //queue에서 꺼내오기
            int[] cur = q.poll();
            int curR = cur[0], curC = cur[1], distance = cur[2];

            //목적지면 반환
            if (curR == r-1 && curC == c-1) return distance;

            //아니면 BFS
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c
                        && maps[nextR][nextC] == 1) {
                    //****방문하지 않았던 곳이면
                    if (!visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        q.add(new int[]{nextR, nextC, distance+1});
                    }
                }
            }
        }
        //못찾으면 -1반환
        return -1;
    }
}