package week3;

import java.util.*;
//보물지도 -> BFS
class Programers121690 {
    static int dr[] = {0, 1, 0, -1, 0, 2, 0, -2};
    static int dc[] = {-1, 0, 1, 0, -2, 0, 2, 0};

    public int solution(int n, int m, int[][] hole) {
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
            int[] curr = q.poll();
            int curR = curr[0], curC = curr[1], isJumped = curr[2], distance = curr[3];


            //점프하지 않았다면
            if (isJumped == 0) {
                for (int i = 0; i <= 7; i++) {
                    int nextR = curR + dr[i];
                    int nextC = curC + dc[i];
                    int nextJ = 0;

                    if (i / 4 >= 1) {
                        nextJ = 1;
                    }

                    if (nextR >= 1 && nextR <= n && nextC >= 1 && nextC <= m) {
                        //유효한 범위 내, 방문한 적 없고 장애물이 아니라면
                        if (!visited[nextR][nextC][nextJ] && !trap[nextR][nextC]) {
                            visited[nextR][nextC][nextJ] = true;

                            //목적지라면 반환
                            if (nextR == n && nextC == m) {
                                return distance + 1;
                            }

                            q.add(new int[]{nextR, nextC, nextJ, distance+1});
                        }
                    }

                }
            } else {
                //이미 점프 했다면
                for (int i = 0; i < 4; i++) {
                    int nextR = curR + dr[i];
                    int nextC = curC + dc[i];
                    int nextJ = 1;

                    if (nextR >= 1 && nextR <= n && nextC >= 1 && nextC <= m) {
                        //유효한 범위 내, 방문한 적 없고 장애물이 아니라면
                        if (!visited[nextR][nextC][nextJ] && !trap[nextR][nextC]) {
                            visited[nextR][nextC][nextJ] = true;

                            //목적지라면 반환
                            if (nextR == n && nextC == m) {
                                return distance + 1;
                            }

                            q.add(new int[]{nextR, nextC, nextJ, distance+1});
                        }
                    }

                }
            }
        }

        return -1;
    }
}