package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// blog 참고
public class P5972 {
    static int n;
    static int m;
    static int[][] positions;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

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
        positions = new int[m][3];
        dist = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i][0] = Integer.parseInt(st.nextToken());
            positions[i][1] = Integer.parseInt(st.nextToken());
            positions[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            graph.get(positions[i][0]).add(new Node(positions[i][1], positions[i][2]));
            graph.get(positions[i][1]).add(new Node(positions[i][0], positions[i][2]));
        }

        Arrays.fill(dist,Integer.MAX_VALUE);

        bfs(1);
        System.out.println(dist[n]);
    }

    private static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node position = pq.poll();

            for (Node nextNode : graph.get(position.to)) {
                if(dist[nextNode.to] > dist[position.to] + nextNode.cost) {
                    dist[nextNode.to] = dist[position.to] + nextNode.cost;
                    pq.add(new Node(nextNode.to, dist[nextNode.to]));
                }
            }
        }
    }
}
