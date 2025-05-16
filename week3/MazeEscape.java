package week3;

import java.util.*;
class MazeEscape {
    static int[] dr = {1, 1, 0, 0};
    static int[] dc = {0, 1, 1, 0};
    static int rowLen;
    static int colLen;
    static String[] maps;
    public int solution(String[] maps) {
        int answer = 0;
        rowLen = maps.length;
        colLen = maps[0].length();
        char[][] maze = new char[rowLen][colLen];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for (int r = 0; r < rowLen; r++) {
            maze[r] = maps[r].toCharArray();
            for (int c = 0; c < colLen; c++) {
                if (maze[r][c] == 'S') {
                    start[0] = r;
                    start[1] = c;
                } else if (maze[r][c] == 'L') {
                    lever[0] = r;
                    lever[1] = c;
                } else if (maze[r][c] == 'E') {
                    exit[0] = r;
                    exit[1] = c;
                }
            }
        }

        int time1 = bfs(maze, start, lever);
        int time2 =  bfs(maze, lever, exit);

        if (time1 == -1 || time2 == -1) return -1;
        else return time1 + time2;
    }

    public static int bfs(char[][] maze, int[] start, int[] target) {
        boolean[][] visited = new boolean[rowLen][colLen];
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0}); // 좌표랑 거리(0)까지 함께 저장
        visited[start[0]][start[1]] = true; // 시작점 방문 true로 변경

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int distance = curr[2];

            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextR >= 0 && nextR < rowLen
                        && nextC >= 0 && nextC < colLen
                        && maze[nextR][nextC] != 'X') {
                    if (!visited[nextR][nextC]) {
                        if (nextR == target[0] && nextC == target[1])
                            return distance+1;
                        q.add(new int[]{nextR, nextC, distance+1});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
        return -1;//impossible to reach
    }
}