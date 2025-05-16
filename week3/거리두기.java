package week3;

import java.util.*;

public class 거리두기 {
    static String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
    };
    static int[] answer;
    static int rowLen = 5;
    static int colLen = 5;
    static final int[] dr = {  0,  1,  0, -1 };
    static final int[] dc = {  1,  0, -1,  0 };

    public static void main(String[] args) {
        answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            }
        }
        System.out.println(Arrays.toString(answer));
    }


    static boolean check(String[] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //✅ 응시자(P) 위치 마다 BFS를 수행
                if (room[i].charAt(j) == 'P') {
                    if (!bfs(i, j, room)) return false;
                }
            }
        }
        return true;
    }

    static boolean bfs (int row, int col, String[] room) {
        boolean[][] visited = new boolean[5][5];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col, 0});

        visited[row][col] = true;//시작점 설정

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[2] >= 2) continue; //맨해튼 거리가 2보다 크면 거리두기 완료

            for (int i = 0; i < 4; i++) {
                int nextRow = curr[0] + dr[i];
                int nextCol = curr[1] + dc[i];
                int dist = curr[2] + 1;

                if (nextRow >= 0 && nextRow < rowLen && nextCol >= 0 && nextCol < colLen && room[nextRow].charAt(nextCol) != 'X') {
                    if (!visited[nextRow][nextCol]) {
                        //거리두기 준수 X
                        if (room[nextRow].charAt(nextCol) == 'P') return false;
                        q.add(new int[]{nextRow, nextCol, dist});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return true;
    }
}
