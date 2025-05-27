package week3;

import java.util.*;
//보물지도 -> BFS
class Jump {
    static int dr[] = {0, 1, 0, -1, 0, 2, 0, -2};
    static int dc[] = {-1, 0, 1, 0, -2, 0, 2, 0};
    public int solution(int n, int m, int[][] hole) {
        int answer = 0;

        //함정 위치 표시
        boolean[][] trap = new boolean[n+1][m+1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        //visited 선언
        // 0 -> 점프 사용 안함, 1 -> 점프 사용함
        boolean[][][] visited = new boolean[n+1][m+1][2];
        //Queue 선언
        Queue<int[]> q = new ArrayDeque<>();
        visited[1][1][0] = true;
        q.add(new int[]{1, 1, 0, 0});

        //BFS 시작
        while(!q.isEmpty()) {
        }



        return answer;
    }
}