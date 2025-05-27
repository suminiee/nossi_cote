package week3;

import java.util.*;

class 송전탑answer {
    int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        //✅ 주어진 엣지 데이터를 사용하기 쉽게 가공한다.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        //✅ DFS 탐색을 수행하며 답을 구한다.
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);

        return answer;
    }

    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int n) {
        int count = 1;
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                count += dfs(graph, visited, next, n);
            }
        }
        //✅ 최적값을 업데이트한다.
        answer = Math.min(answer, Math.abs(n - count * 2));

        //✅ 자신 아래의 노드 수를 재귀적으로 반환한다.
        return count;
    }

    // for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
    //     String key = entry.getKey();
    //     List<String> value = entry.getValue();
    //     System.out.println(key + " : " + value);
    // }
}