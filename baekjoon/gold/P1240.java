package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1240 {
    static int n;
    static int m;
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();
    static int[][] diffDIst;
    static boolean[] visited;
    static int[] answer;

    static class Node {
        int to;
        int cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        diffDIst = new int[m][2];
        answer = new int[m];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            diffDIst[i][0] = Integer.parseInt(st.nextToken());
            diffDIst[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            visited = new boolean[n + 1];
            dist = new int[n + 1];
            bfs(diffDIst[i][0], diffDIst[i][1]);
            System.out.println(dist[diffDIst[i][1]]);
        }
    }

    private static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curentNode = queue.poll();

            for (Node nextNode : graph.get(curentNode.to)) {
                if(visited[nextNode.to]) {
                    continue;
                }

                if(nextNode.to == end) {
                    dist[nextNode.to] += dist[curentNode.to] + nextNode.cost;
                    break;
                }

                visited[curentNode.to] = true;
                dist[nextNode.to] = dist[curentNode.to] + nextNode.cost;
                queue.add(new Node(nextNode.to, dist[nextNode.to] + nextNode.cost));
            }
        }
    }
}
