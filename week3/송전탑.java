package week3;

import java.util.*;
class 송전탑 {
    public int solution(int n, int[][] wires) {
        int answer = n;

        //데이터 가공
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        //DFS
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);

        return answer;
    }

    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int n, int cur) {
        int count = 1;
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count += dfs(graph, visited, n, next);
            }
        }

        //최적 값 업데이트
        count = Math.min(count, Math.abs(n - count*2));

        //자신 아래 노드의 수를 재귀적으로 반환
        return count;
    }
}