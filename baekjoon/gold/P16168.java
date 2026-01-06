package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16168 {
    static int n;
    static int m;
    static int[] degree;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        degree = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
            degree[a]++;
            degree[b]++;
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(degree[i] % 2 != 0) {
                count++;
            }
        }

        // 홀수인 간선이 없거나 시작노드와 끝노드가 홀수인 경우
        if(!(count == 0 || count == 2)) {
            System.out.println("NO");
            return;
        }

        int start = - 1;
        for(int i = 1; i <= n; i++) {
            if(degree[i] > 0) {
                start = i;
                break;
            }
        }

        if(start == -1) {
            System.out.println("YES");
            return;
        }

        dfs(start);

        for(int i = 1; i <= n; i++) {
            if(degree[i] > 0 && !visited[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
