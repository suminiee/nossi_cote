package week3;

import java.util.*;
class 응급차_최단_거리2 {
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int rowLen;
    static int colLen;
    static int[][] distance;

    public int solution(int[][] city) {

        rowLen = city.length;
        colLen = city[0].length;
        distance = new int[rowLen][colLen];

        //거리 배열 초기화
        for (int[] row : distance) {
            Arrays.fill(row ,-1);
        }
        if (city[0][0] != 1) {
            bfs(city, 0, 0);
            return distance[rowLen-1][colLen-1];
        } else {
            return -1;
        }


    }
    public static void bfs(int[][] city, int startRow, int startCol) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol});
        distance[startRow][startCol] = 1; // 시작 점 거리 설정

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];

            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                // 범위 내에 있고 이동 가능하며, 아직 방문하지 않은 경우
                if (nextRow >= 0 && nextRow < rowLen
                        && nextCol >= 0 && nextCol < colLen
                        && city[nextRow][nextCol] == 0) {
                    if (distance[nextRow][nextCol] == -1 ) { // 방문 전이라면
                        distance[nextRow][nextCol] = distance[curRow][curCol] + 1;
                        q.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
    }
}