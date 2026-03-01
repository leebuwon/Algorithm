package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    static int n;
    static int k;
    static boolean[] visited;
    static int[] dist;
    static int[] direction = {1, -1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        visited = new boolean[100001];

        bfs(n);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        dist[n] = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if(now == k) {
                break;
            }

            for(int i = 0; i < 3; i++) {
                int next;
                if(i != 2) {
                    next = now + direction[i];
                } else {
                    next = now * direction[i];
                }

                if(next < 0 || next >= 100001) {
                    continue;
                }

                if(visited[next]) {
                    continue;
                }

                visited[next] = true;
                dist[next] = dist[now] + 1;
                queue.add(next);
            }


        }

        System.out.println(dist[k]);
    }
}
