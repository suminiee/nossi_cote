package week3;

class Solution {
    static int row, col;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 아직 방문 안 했고 땅(‘1’)이라면 새 섬 발견!
                if (!visited[i][j] && grid[i][j] == '1') {
                    answer++;
                    DFS(grid, i, j);
                }
            }
        }
        return answer;
    }

    public static void DFS(char[][] grid, int r, int c) {
        // 범위 밖이거나 이미 방문했거나 바다(‘0’)면 중단
        if (r < 0 || r >= row || c < 0 || c >= col) return;
        if (visited[r][c] || grid[r][c] == '0') return;

        visited[r][c] = true;
        // 4방향으로 땅이 이어진 곳 모두 방문 표시
        for (int k = 0; k < 4; k++) {
            DFS(grid, r + dr[k], c + dc[k]);
        }
    }
}