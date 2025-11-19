package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2252 {
    static int n;
    static int m;
    static List<Integer>[] graph;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);

            // b는 a보다 뒤에 와야 하므로 진입 차수 +1
            indegree[b]++;
        }

        System.out.println(Arrays.toString(graph));
        System.out.println(Arrays.toString(indegree));

        bfs();
        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            sb.append(current).append(" ");

            for(int next : graph[current]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
