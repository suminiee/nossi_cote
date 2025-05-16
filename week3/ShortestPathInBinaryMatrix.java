package week3;

import java.util.*;
//https://leetcode.com/problems/shortest-path-in-binary-matrix/
class ShortestPathInBinaryMatrix {
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int rowLen;
    static int colLen;
    static int[][] distance;
    public int shortestPathBinaryMatrix(int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;

        distance = new int[rowLen][colLen];

        //거리 배열 초기화
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        //bfs
        bfs(grid, 0, 0);

        if (grid[0][0] == 0) {
            return distance[rowLen-1][colLen-1];
        } else {
            return -1;
        }
    }

    public static void bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c}); // 시작점 큐에 넣기

        distance[r][c] = 1; //시작점 거리 초기화

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];

            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if (nextRow >= 0 && nextRow < rowLen
                        && nextCol >= 0 && nextCol < colLen
                        && grid[nextRow][nextCol] == 0) {
                    if (distance[nextRow][nextCol] == -1) { // 아직 방문 전이라면
                        distance[nextRow][nextCol] = distance[curRow][curCol] + 1;
                        q.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
    }
}