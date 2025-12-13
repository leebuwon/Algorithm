package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
    static int n;
    static int m;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
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

        bfs(1);

        System.out.println(count);

    }

    private static void bfs(int virus) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(virus);
        visited[virus] = true;

        while (!queue.isEmpty()) {
            Integer virusComputer = queue.poll();

            for (Integer nextComputer : graph.get(virusComputer)) {
                if(visited[nextComputer]) {
                    continue;
                }

                queue.add(nextComputer);
                count++;
                visited[nextComputer] = true;
            }
        }
    }
}
