package week2;

import java.util.*;
public class BFS {
    public void bfs(List<List<Integer>> graph, int startVertex) {
        //====== 코드 작성 =====
        //시작점 예약
        Queue<Integer> queue = new LinkedList<>();
        final int n = graph.size();
        boolean[] visited = new boolean[n];
        queue.add(startVertex);
        //시작점은 방문한게 되니까 visited를 true로 바꿔주기
        visited[startVertex] = true;

        //queue
        while(!queue.isEmpty()) {
            int curVertex = queue.poll();
//            System.out.println(curVertex);

            for (int nextVertex : graph.get(curVertex)) {
                if (!visited[nextVertex]) {
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }

        //====================
    }

    public void solve(List<List<Integer>> graph) {
        bfs(graph, 0);
    }

    // 실행용 메소드
    public static void main(String[] args) {
        (new BFS()).solve(makeGraph());
    }

    public static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));
        }};
    }

}
