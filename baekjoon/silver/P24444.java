package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24444 {
    static int n;
    static int m;
    static int r;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        answer = new int[n + 1];

        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        int count = 1;
        answer[r] = count;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : graph.get(now)) {
                if(visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
                count++;
                answer[next] = count;
            }

        }
    }
}
